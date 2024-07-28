package i_dao;


public interface I_FrmProduct {
	public void addProduct();
	public void renderTableProduct();
	public void updateProduct();
	public boolean validatationInputProduct();
	public void deleteProduct();
	public void sortTableByName();
	//public void setUpTextFieldPrice();
	public void renderTableProduct_FindByName();
	public void resetFrm();
}
