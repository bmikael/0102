package com.amlm.honeygogroceryshopping.tests.TestEditMasterItem;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.RoboGuice;
import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.amlm.honeygogroceryshopping.activities.EditMasterItemActivity;
import com.amlm.honeygogroceryshopping.activities.R;
import com.amlm.honeygogroceryshopping.dataaccess.DataCache;
import com.amlm.honeygogroceryshopping.model.Category;
import com.amlm.honeygogroceryshopping.model.GroceryItem;
import com.amlm.honeygogroceryshopping.tests.common.BaseTest;
import com.amlm.honeygogroceryshopping.tests.modules.EmptyGroceryFilesModule;
import com.google.inject.util.Modules;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
public class TestSaveMasterItem extends BaseTest {

	//private ImageButton _btnScan;
	private EditText _etName;
	private EditText _etNotes;
	private EditText _etQuantity;
	private EditText _etUnit;
	private CheckBox _chkSelectByDefault;
	private Button _btnCancel;
	
	private Button _btnApply;
	
	private Spinner _spinCat;
	private EditMasterItemActivity _activity;
	
	@Before
	public void setup()
	{
		RoboGuice.setBaseApplicationInjector(Robolectric.application, RoboGuice.DEFAULT_STAGE, Modules.override(RoboGuice.newDefaultRoboModule(Robolectric.application)).with(new EmptyGroceryFilesModule()));
		
		super.setup();
		try {
			ShadowActivity shadow ;	      
			_activity = (EditMasterItemActivity) new EditMasterItemActivity();
			shadow = shadowOf(_activity);
			
			shadow.setIntent(createIntentToEditGroceryItem());
			_activity.onCreate(null);
		} catch (Exception e) {
			fail(e.getMessage());
		}
//		_btnScan = (ImageButton)_activity.findViewById(R.id.btnScan);
		_spinCat = (Spinner)_activity.findViewById(R.id.location_spinner);
		_etName = (EditText)_activity.findViewById(R.id.edit_name);
		_etNotes = (EditText)_activity.findViewById(R.id.edit_notes);
		_etQuantity = (EditText)_activity.findViewById(R.id.edit_quantity);
		_etUnit = (EditText)_activity.findViewById(R.id.edit_unitOrSize);
		_chkSelectByDefault = (CheckBox)_activity.findViewById(R.id.selectByDefault);
		_btnCancel = (Button)_activity.findViewById(R.id.button_cancel);
//		_btnDelete = (Button)_activity.findViewById(R.id.button_delete);
		_btnApply = (Button)_activity.findViewById(R.id.button_save);
		
	}
	
	@After
	public void teardown()
	{
		
		super.teardown();
	}
	
	@Test
	public void testSaveItemCheckedByDefaultNoQuantity()
	{
		String newName = "updated name";
		String newNotes = "some random, updated notes";
		Category newCat = GroceryItem.getDefaultCategory();
		String newUnit = "updated unit";
		
		editItem(newName, newNotes , null, newUnit, true, newCat);
		_btnApply.performClick();
		GroceryItem itemEdited = _activity.getItem();
		assertTrue(itemEdited.getSelected());
		assertEquals(newName, itemEdited.getName());
		assertEquals(newNotes, itemEdited.getNotes());
		assertEquals(newCat, itemEdited.getCategory());
		assertEquals(newUnit, itemEdited.getUnitsOrSize());
		assertEquals(0, itemEdited.getQuantity(),.001);
		
		assertEquals(Activity.RESULT_OK, shadowOf(_activity).getResultCode());
	}
	@Test
	public void testCancelEdit()
	{
		GroceryItem itemEdited = _activity.getItem();
		String newName = "updated name";
		String newNotes = "some random, updated notes";
		Category newCat = getCategory();
		String newUnit = "updated unit";
		int quantity = 3;
		
		String oldName = itemEdited.getName();
		String oldNotes = itemEdited.getNotes();
		Category oldCat = itemEdited.getCategory();
		String oldUnit = itemEdited.getUnitsOrSize();
		double oldQuantity = itemEdited.getQuantity();
		boolean oldSelected = itemEdited.getSelected();
		
		editItem(newName, newNotes , quantity, newUnit, !oldSelected, newCat);
		_btnCancel.performClick();
		
		assertTrue(itemEdited.getSelected());
		assertEquals(oldName, itemEdited.getName());
		assertEquals(oldNotes, itemEdited.getNotes());
		assertEquals(oldCat, itemEdited.getCategory());
		assertEquals(oldUnit, itemEdited.getUnitsOrSize());
		assertEquals(oldQuantity, itemEdited.getQuantity(), .001);
		
		assertEquals(Activity.RESULT_CANCELED, shadowOf(_activity).getResultCode());
	}
	@Test
	public void testSaveItemNotCheckedByDefaultWithQuantity()
	{
		String newName = "updated name";
		String newNotes = "some random, updated notes";
		Category newCat = GroceryItem.getDefaultCategory();
		String newUnit = "updated unit";
		int newQuantity = 1;
		
		editItem(newName, newNotes , newQuantity, newUnit, false, newCat);
		_btnApply.performClick();
		GroceryItem itemEdited = _activity.getItem();
		assertFalse(itemEdited.getSelected());
		assertEquals(newName, itemEdited.getName());
		assertEquals(newNotes, itemEdited.getNotes());
		assertEquals(newCat, itemEdited.getCategory());
		assertEquals(newUnit, itemEdited.getUnitsOrSize());
		assertEquals(newQuantity, itemEdited.getQuantity(), .001);
		
		assertEquals(Activity.RESULT_OK, shadowOf(_activity).getResultCode());
	}	
	@Test
	public void testSaveItemWithNewCategory()
	{
		String newName = "updated name";
		String newNotes = "some random, updated notes";
		Category newCat =getCategory();
		String newUnit = "updated unit";
		int newQuantity = 1;
		
		editItem(newName, newNotes , newQuantity, newUnit, false, newCat);
		_btnApply.performClick();
		GroceryItem itemEdited = _activity.getItem();
		assertFalse(itemEdited.getSelected());
		assertEquals(newName, itemEdited.getName());
		assertEquals(newNotes, itemEdited.getNotes());
		assertEquals(newCat, itemEdited.getCategory());
		assertEquals(newUnit, itemEdited.getUnitsOrSize());
		assertEquals(newQuantity, itemEdited.getQuantity(), .001);
		
		assertEquals(Activity.RESULT_OK, shadowOf(_activity).getResultCode());
	}	
	private void editItem(String newName, String newNotes, Integer quantity, String newUnits,
			Boolean selectByDefault, Category newCat)
	{
		if (newName != null)
		{
			_etName.setText(newName);
		}
		if (newNotes != null)
			{
			_etNotes.setText(newNotes);
			}
		if (quantity != null)
			{_etQuantity.setText(quantity.toString());
			}
		if (newUnits != null)
			{
			_etUnit.setText(newUnits);
			}
		if (selectByDefault != null)
			{_chkSelectByDefault.setChecked(selectByDefault);
			}
		if (newCat != null)
		{
			ArrayList<Category> cats = _activity.getPossibleLocations();
			int position = cats.indexOf(newCat);
			
			_spinCat.setSelection(position);
		}
	}
	protected Category getCategory()
	{
		ArrayList<Category> cats= DataCache.getCategories();
		Random randomNumberGenerator = new Random();
		Category ret = null;
		do
			{
			ret = cats.get(randomNumberGenerator.nextInt(cats.size()-1));
			}
		while (ret.getName().equals(GroceryItem.DEFAULT_CATEGORY_NAME));
		return ret;
		
	}
	
}
