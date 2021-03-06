package com.amlm.honeygogroceryshopping.tests.mocks.groceryfile;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;

import com.amlm.honeygogroceryshopping.dataaccess.BaseGroceryFile;

public class EmptyGroceryFileMock extends BaseGroceryFile {
	private final static String _catFileName = "category.json"; 
	private String _contents = null;
	public static final int [] numberOfSectionsPerAisle = new int [] 
			{1,44};

			//	{0,1,3,2,4,3,2,5,3,1,3,1,3,2,1,3,1,1,3,2,1};
	
	@Override
	public String read() throws IOException, Exception {
		// TODO Auto-generated method stub
		return _contents;
	}


		
	@Override
	public void save(String contents) throws FileNotFoundException,
			IOException, JSONException {
		// TODO Auto-generated method stub
		
			_contents = contents;
		
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		_contents = null;
	}
	
	@Override
	public boolean exists()
	{
		//return false;
		return (_contents != null);
	}

	@Override
	public String createFromAssets() throws IOException, JSONException {
		if (this.getFileName().equals(_catFileName))
		{
			_contents = "[{\"id\":\"a6eeabae-491d-4680-ab50-696f7e30769c\",\"order\":\"0\",\"name\":\"unknown\"},{\"id\":\"23c67a59-1c43-4c1d-8fc4-af95a8b7a947\",\"order\":\"1\",\"name\":\"deli\"},{\"id\":\"9163bfe9-f601-4ddc-928a-46d1f6772fb4\",\"order\":\"1\",\"name\":\"meat and poultry\"},{\"id\":\"8edb11d2-7f6f-4943-ad00-8fe54228b051\",\"order\":\"1\",\"name\":\"produce\"},{\"id\":\"9ac05a99-86a3-4456-adea-98bb650be8c5\",\"order\":\"1\",\"name\":\"frozen meats\"},{\"id\":\"c96c2705-3c13-4402-9993-e671aff72568\",\"order\":\"1\",\"name\":\"pharmacy\"},{\"id\":\"93d513af-116a-44b8-a9ef-d74e83eaa853\",\"order\":\"1\",\"name\":\"health and beauty\"},{\"id\":\"da3330fc-964c-4bc3-9ed8-d16103f94b88\",\"order\":\"1\",\"name\":\"makeup\"},{\"id\":\"e5ba5936-16c2-477b-b2af-a534ddbabab3\",\"order\":\"1\",\"name\":\"moisturizers\"},{\"id\":\"48da27f7-984d-41cf-b8fb-779ad22f3b66\",\"order\":\"1\",\"name\":\"oral hygiene\"},{\"id\":\"c21b6e79-5007-4232-adff-bb1dbdfb166f\",\"order\":\"1\",\"name\":\"feminine products\"},{\"id\":\"bc304729-3b09-4ac5-8412-3601d4dd1645\",\"order\":\"1\",\"name\":\"hair care\"},{\"id\":\"b6eeabae-491d-4680-ab50-696f7e30769c\",\"order\":\"1\",\"name\":\"packaged deli\"},{\"id\":\"ef11264d-c3cf-4ab8-86d1-dd54c5d9416c\",\"order\":\"1\",\"name\":\"school supplies\"},{\"id\":\"9e03874d-7fe4-48c7-a2f4-7487bca82749\",\"order\":\"1\",\"name\":\"vitamins\"},{\"id\":\"9eca7ee7-1045-4b00-af0a-e5d5cbecec0e\",\"order\":\"1\",\"name\":\"Mex food\"},{\"id\":\"2c52eefe-4a28-4c08-bc2d-29880fcf780c\",\"order\":\"1\",\"name\":\"candy\"},{\"id\":\"9282ce25-2324-402d-ae4c-7b4e72e1a18f\",\"order\":\"1\",\"name\":\"dairy\"},{\"id\":\"65922614-b751-4385-b773-6f7b6007b0bd\",\"order\":\"1\",\"name\":\"fruit juices\"},{\"id\":\"0b3d24c6-626f-492e-a319-7fd1d0635745\",\"order\":\"1\",\"name\":\"paper plates, cups, aluminum foil\"},{\"id\":\"d60fcd25-ef15-43f6-82c8-3a1a6c4b6ff9\",\"order\":\"1\",\"name\":\"canned meats\"},{\"id\":\"5e91bd15-68d0-480d-9aea-7c2fdf1a82d7\",\"order\":\"1\",\"name\":\"canned meats and dressings\"},{\"id\":\"8cc087bb-be14-4bb0-ab3c-d62b1dc6f7dd\",\"order\":\"1\",\"name\":\"soups\"},{\"id\":\"a0fb528d-9be1-44e7-a735-400a9b0e3376\",\"order\":\"1\",\"name\":\"cheeses\"},{\"id\":\"bb33db94-3ab0-4af6-be41-146be4d50500\",\"order\":\"1\",\"name\":\"cake mixes\"},{\"id\":\"f50ad512-1307-4186-b3f4-5f3eb855e123\",\"order\":\"1\",\"name\":\"cookies and crackers\"},{\"id\":\"9dcc9842-ca71-48d9-ba54-69c42d112f81\",\"order\":\"1\",\"name\":\"spices\"},{\"id\":\"7d919a92-9ff3-42a4-900d-1a76c8bdde7a\",\"order\":\"1\",\"name\":\"coffee and breakfast items\"},{\"id\":\"43149a49-4ff4-4f9e-b700-c0dd5cb28ced\",\"order\":\"1\",\"name\":\"pasta\"},{\"id\":\"97539dd1-4c93-485d-a804-da0f7f94f6e1\",\"order\":\"1\",\"name\":\"potatoes and gravies\"},{\"id\":\"35895c65-0e6e-4f3d-b192-c1ff0c373c8f\",\"order\":\"1\",\"name\":\"refrigerated baking\"},{\"id\":\"b951b045-0309-4bee-9a0f-1d9a8d69afc0\",\"order\":\"1\",\"name\":\"cleaning supplies\"},{\"id\":\"af4e613e-ebb7-4cc2-89ff-46625f54cfc2\",\"order\":\"1\",\"name\":\"pet food and supplies\"},{\"id\":\"68cd7c6a-4b90-496d-be92-867be0ca0fd1\",\"order\":\"1\",\"name\":\"creamers\"},{\"id\":\"dd722eda-1aa0-45d6-ab51-47d3f52b0e74\",\"order\":\"1\",\"name\":\"milk products\"},{\"id\":\"3338e001-5b3f-412f-aca2-e70988b1521e\",\"order\":\"1\",\"name\":\"snacks, nuts,water\"},{\"id\":\"67b9ea3d-aea1-4dcc-9d15-751ea1735763\",\"order\":\"1\",\"name\":\"chips and sodas\"},{\"id\":\"f8c7a638-aee2-437e-adb2-e5d16120c3e3\",\"order\":\"1\",\"name\":\"breads\"},{\"id\":\"f15c50ad-dce4-436d-b6ee-37211644606c\",\"order\":\"1\",\"name\":\"frozen TV dinners\"},{\"id\":\"10fdef20-c46a-45c6-b819-7f22cef367f4\",\"order\":\"1\",\"name\":\"frozen appetizers / snacks\"},{\"id\":\"8e9b6500-87c0-4e0e-81c7-8c2580a0d9ac\",\"order\":\"1\",\"name\":\"frozen vegetables\"},{\"id\":\"8e187a6e-f40f-4b74-b178-f99b5156e646\",\"order\":\"1\",\"name\":\"frozen breakfast\"},{\"id\":\"3f725ec1-142f-4fb4-b9eb-ca458aeccd66\",\"order\":\"1\",\"name\":\"frozen desserts\"},{\"id\":\"e2502ba2-30a6-455e-b6c9-69ccfd0a95e4\",\"order\":\"1\",\"name\":\"stationery\"},{\"id\":\"f25e5a59-418d-4890-9c55-995e8e5e8e91\",\"order\":\"1\",\"name\":\"test\"}]";
		}
		return _contents;
		//return "[{\"id\":\"a6eeabae-491d-4680-ab50-696f7e30769c\",\"order\":\"0\",\"name\":\"unknown\"},{\"id\":\"23c67a59-1c43-4c1d-8fc4-af95a8b7a947\",\"order\":\"0\",\"name\":\"deli\"}]";
	}
	

}
