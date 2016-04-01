
package src.GDS;
import java.util.*;
import java.util.Map.Entry;

public class Supplier {
	/**
	 * contain supplier id
	 */
	private long id;
	/**
	 * contain supplier name
	 */
	private String name;
 	/**
	 * contain the list of product of the supplier
	 * Long: id of the product
	 * Double: supplier product price
 	 */
	private HashMap<Long, Double> productList;
	/**
	 * create a supplier
	 * @param id identification of supplier
	 * @param name name of the supplier
	 */
	public Supplier(long id, String name){
		this.id=id;
		this.name=name;
		productList = new HashMap<Long,Double>();
	}
	/**
	 * return the name of the supplier
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	/**
	 * modify the name of the supplier
	 * @param name contain the new name of the supplier
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * return the supplier id
	 * @return long id
	 */
	public long getId() {
		return id;
	}
	/**
	 * return the table of the supplier's product with thier price
	 * @return HashMap productList
	 */
	public HashMap<Long, Double> getProductList() {
		return productList;
	}
	/**
	 * modify the attributes of a supplier
	 * @param name the new name of the product
	 */
	public void modify(String name){
		setName(name);
	}
	/**
	 * add a new product in the supplier's products list
	 * @param product contain the new product
	 * @param price	contain the price of the product
	 */
	public void addProduct(long pdtId, Double price){
		productList.put(pdtId, price);
		//System.out.println(productList.get(product));
	}
	/**
	 * remove a product from the list of the supplier
	 * @param product contain the product which we want to remove of the list
	 */
	public void deleteProduct(long product){
		productList.remove(product);
	}
	/**
	 * Change the product price by his Id
	 * @param productId id of the product which we set the price
	 * @param price new price of the product
	 */
	public void setProductPrice(long productId, double price){
		for(Entry<Long, Double> entry : productList.entrySet()){
			if(productId==entry.getKey()){
				System.out.println("trouv�");
				productList.put(entry.getKey(), price);
			}
		}
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setProductList(HashMap<Long, Double> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", productList=" + productList + "]";
	}
}
