package src.dao;

import java.sql.*;
import java.util.*;

import src.gds.Product;

//import projetDeveloppementLogiciel.Product;
/**
 * class ProductDAO
 * 
 * @author Junior FOTSING KENGNE - HE Junyang
 * @version 1.0
 */
public class ProductDAO extends DAO {

	/**
	 * add product in the date base
	 * 
	 * @param product
	 *            - product to add
	 * @return the number of line add in the product list
	 */
	public int addProduct(Product product) {
		/*Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		// connection to date base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO product_pdt (pdt_id, pdt_name, pdt_stock) VALUES(pdtid_seq.NEXTVAL,?,?)");
			// ps.setLong(1, product.getId());
			ps.setString(1, product.getName());
			ps.setInt(2, product.getStock());

			// excecution of the requiere
			retour = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close preparedStatement and connexion
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
		}
		return retour;*/
		return this.addLine("Product", product);
	}

	/**
	 * return a specific product by his identifiant
	 * 
	 * @param id
	 *            identifiant of the product
	 * @return retourn - the product
	 */
	public Product getProduct(long id) {
		/*
		 * Connection con = null; PreparedStatement ps = null; ResultSet rs =
		 * null; Product retour = null;
		 * 
		 * // connection to the data base try { con =
		 * DriverManager.getConnection(URL, LOGIN, PASS); ps =
		 * con.prepareStatement(
		 * "SELECT * FROM product_pdt LEFT JOIN supplier_spr ON pdt_spr = spr_id WHERE pdt_id = ? "
		 * ); ps.setLong(1, id); rs = ps.executeQuery(); if (rs.next()) retour =
		 * new Product(rs.getLong("pdt_id"), rs.getString("pdt_name"),
		 * rs.getInt("pdt_stock"), rs.getDouble("pdt_price"),
		 * rs.getLong("pdt_spr"), rs.getString("spr_name")); } catch (Exception
		 * ee) { ee.printStackTrace(); } finally { // closing of ResultSet,
		 * PreparedStatement and connection try { if (rs != null) rs.close(); }
		 * catch (Exception ignore) { } try { if (ps != null) ps.close(); }
		 * catch (Exception ignore) { } try { if (con != null) con.close(); }
		 * catch (Exception ignore) { } } return retour;
		 */
		String sql = "SELECT * FROM product_pdt LEFT JOIN supplier_spr ON pdt_spr = spr_id WHERE pdt_id = ? ";
		return (Product) this.getOne("Product", sql, id);
	}

	/**
	 * allow to have the full list of product presents in the data base
	 * 
	 * @return the list of all the products in the data base
	 */
	public ArrayList<Product> getProductList() {
		/*Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Product> retour = new ArrayList<Product>();
		// connection to the data base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM product_pdt LEFT JOIN supplier_spr on spr_id = pdt_spr");

			// requet execution
			rs = ps.executeQuery();

			// we crosse all the line of the results
			while (rs.next())
				retour.add(new Product(rs.getLong("pdt_id"), rs
						.getString("pdt_name"), rs.getInt("pdt_stock"), rs
						.getDouble("pdt_price"), rs.getLong("pdt_spr"), rs
						.getString("spr_name")));
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// closing rs, PreparedStatement and connection
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;*/
		String sql = "SELECT * FROM product_pdt LEFT JOIN supplier_spr on spr_id = pdt_spr";
		return (ArrayList<Product>)this.getList("Product", sql, 0, 0l);
	}

	/**
	 * delete a product in the data base product list
	 * 
	 * @param id
	 *            contain the id of the product we want to delete
	 * @return the number of line delete
	 */
	public int deleteProduct(long id) {
		/*Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		// connection to date base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM product_pdt WHERE pdt_id=?");
			ps.setLong(1, id);

			// excecution of the requiere
			retour = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close preparedStatement and connexion
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
		}
		return retour;*/
		return this.deleteLine("Product", id);
	}

	public int updateProduct(Product product){
		return this.updateLine("Product", product);
	}
	
	/**
	 * generate a new id for the product_pdt
	 * 
	 * @return retour the new id of the product
	 */
	public long idGenerator() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		long retour = 0;
		// connection to date base
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT MAX(pdt_id) FROM product_pdt");

			// excecution of the requiere
			rs = ps.executeQuery();
			// recuperation of number
			rs.next();
			retour = rs.getLong(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close preparedStatement and connection
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
				System.out.println("closing problem");
			}
		}
		return (retour + 1);
	}

	// TODO int updateProduct(Product pdt)

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		// System.out.println("id gen next pdt_id = " + dao.idGenerator());
		
//		System.out.println("Get Product Id 2 : ");
//		System.out.println(dao.getProduct(2).toString());
//		System.out.println("Get List : ");
//		System.out.println(dao.getProductList().toString());
//		System.out.println("Add Product : ");
//		System.out.println(dao.addProduct(new Product("aaasssddd")));
//		System.out.println("Delete Product : ");
//		System.out.println(dao.deleteProduct(1));
		System.out.println("Update Product : ");
		System.out.println(dao.updateProduct(new Product(1, "updatedName", 999, 1.11, 2, "123")));
		
	}
}
