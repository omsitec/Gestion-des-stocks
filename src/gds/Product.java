package gds;

/**
 * class product, represents a product
 * 
 * @author FOTSING KENGNE Junior - HE junyang
 * @version 1.0
 */
public class Product implements Comparable<Product> {

	/**
	 * contains product id.
	 */
	private long id;
	/**
	 * contains product name.
	 */
	private String name;
	/**
	 * contains product price.
	 */
	private double price;
	/**
	 * contains available stock for the product.
	 */
	private int stock;
	/**
	 * contain the product's supplier id.
	 */
	private long supplierId;
	/**
	 * contain the name of product's supplier.
	 */
	private String supplierName;

	/**
	 * create a new product.
	 * 
	 * @param id
	 *            product id
	 * @param name
	 *            product name
	 */
	public Product(long id, String name) {
		this.id = id;
		this.name = name;
		this.stock = 0;
		this.price = 0;
		this.supplierId = 0L;
		this.supplierName = null;
	}

	/**
	 * get a product from db.
	 * 
	 * @param id
	 *            product id
	 * @param name
	 *            product name
	 * @param stock
	 *            product stock
	 * @param price
	 *            product price
	 * @param supplierId
	 *            supplier id
	 * @param supplierName
	 *            supplier name
	 */
	public Product(long id, String name, int stock, double price, long supplierId, String supplierName) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}

	/**
	 * supplier Id getter.
	 * 
	 * @return supplier id
	 */
	public long getSupplierId() {
		return supplierId;
	}

	/**
	 * supplier id setter.
	 * 
	 * @param supplierId
	 *            new supplier id
	 */
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * supplier name getter.
	 * 
	 * @return supplier name
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * supplier name setter.
	 * 
	 * @param supplierName
	 *            new supplier name
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * product id setter.
	 * 
	 * @param id
	 *            product name
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * product stock setter.
	 * 
	 * @param stock
	 *            new stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * return product name.
	 * 
	 * @return string name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the name of the product.
	 * 
	 * @param name
	 *            the new name of the product
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * return the product Id.
	 * 
	 * @return String id
	 */
	public long getId() {
		return id;
	}

	/**
	 * return the product price.
	 * 
	 * @return double price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * return the available stock of the product.
	 * 
	 * @return int stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * reduce stock quantity by the quantity in parameter.
	 * 
	 * @param quantity
	 *            the quantity of stock to reduce
	 */
	public void reduceStock(int quantity) {
		stock -= quantity;
	}

	/**
	 * Add stock quantity by the quantity in parameter.
	 * 
	 * @param quantity
	 *            the quantity of stock to reduce
	 */
	public void addStock(int quantity) {
		stock += quantity;
	}

	// public void affectSupplier(Supplier supplier) {
	//
	// }
	//
	// public void removeSupplier(long id) {
	//
	// }

	/**
	 * product price setter.
	 * 
	 * @param price
	 *            product price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * toString.
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", supplierId="
				+ supplierId + ", supplierName=" + supplierName + "]";
	}

	/**
	 * Implement the comparable interface. Compare two product by name by
	 * alphabet.
	 */
	@Override
	public int compareTo(Product pdt) {
		return name.compareTo(pdt.getName());
	}
}
