package net.vadique.khpi.vagonkadb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.vadique.khpi.vagonkadb.beans.Order;
import net.vadique.khpi.vagonkadb.beans.ProductInfo;
import net.vadique.khpi.vagonkadb.beans.ProductPrice;
import net.vadique.khpi.vagonkadb.beans.ProductPriceInfo;
import net.vadique.khpi.vagonkadb.beans.ProductSizeInfo;

public class DBUtils {
	 public static List<ProductPriceInfo> select(Connection conn) {
		 List<ProductPriceInfo> productPriceList = new ArrayList<ProductPriceInfo>();
	                Statement statement;
					try {
							statement = conn.createStatement();
						
		                ResultSet resultSet = statement.executeQuery("SELECT * FROM product_price_info");
		                
		                while(resultSet.next()){
		                	String productTypeName = resultSet.getString(1);
		                	String woodTypeName = resultSet.getString(2);
		                	double price = resultSet.getDouble(3);
		                	String woodKindName = resultSet.getString(4);
		                	double lengthFrom = resultSet.getDouble(5);
		                	double lengthTo = resultSet.getDouble(6);
		                	double width = resultSet.getDouble(7);
		                	double thickness = resultSet.getDouble(8);
		                	String muAbbrv = resultSet.getString(9);
		                	ProductPriceInfo product = 
		                			new ProductPriceInfo(productTypeName, woodTypeName, price, woodKindName,
		                					lengthFrom, lengthTo, width, thickness, muAbbrv);
		                    productPriceList.add(product);
	                }
					} catch (SQLException e) {
						e.printStackTrace();
					}

	        return productPriceList;
	    }
	 
	 public static void insertOrder(Connection conn, Order order) {
			 String sql = "INSERT INTO _order (customer_name, customer_phone, customer_email, order_info) Values (?, ?, ?, ?)";
             try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                 preparedStatement.setString(1, order.getCustomerName());
                 preparedStatement.setString(2, order.getCustomerPhone());
                 preparedStatement.setString(3, order.getCustomerEmail());
                 preparedStatement.setString(4, order.getOrderInfo());
                 preparedStatement.executeUpdate();
             } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	 
	 public static List<ProductInfo> selectProducts(Connection conn)  {
		 List<ProductInfo> productList = new ArrayList<ProductInfo>();
					try (Statement statement = conn.createStatement()) {
						
		                ResultSet resultSet = statement.executeQuery("SELECT * FROM product_info");
		                
		                while(resultSet.next()){
		                	int productId = resultSet.getInt(1);
		                	String productTypeName = resultSet.getString(2);
		                	String woodTypeName = resultSet.getString(3);
		                	String woodKindName = resultSet.getString(4);
		                	String muAbbrv = resultSet.getString(5);
		                	ProductInfo product = 
		                			new ProductInfo(productId, productTypeName, woodTypeName, woodKindName, muAbbrv);
		                    productList.add(product);
	                }
					} catch (SQLException e) {
						e.printStackTrace();
					}

	        return productList;
	}
	 
	 public static List<ProductSizeInfo> selectProductSizes(Connection conn)  {
		 List<ProductSizeInfo> productSizesList = new ArrayList<ProductSizeInfo>();
	                Statement statement;
					try {
							statement = conn.createStatement();
						
		                ResultSet resultSet = statement.executeQuery("SELECT * FROM product_size_info");
		                while(resultSet.next()){
		                	String sizedProductId = resultSet.getString(1);
		                	String productTypeName = resultSet.getString(2);
		                	String woodTypeName = resultSet.getString(3);
		                	String woodKindName = resultSet.getString(4);
		                	double lengthFrom = resultSet.getDouble(5);
		                	double lengthTo = resultSet.getDouble(6);
		                	double width = resultSet.getDouble(7);
		                	double thickness = resultSet.getDouble(8);
		                	String muAbbrv = resultSet.getString(9);
		                	ProductSizeInfo product = 
		                			new ProductSizeInfo(sizedProductId, productTypeName, woodTypeName, woodKindName, 
		                					lengthFrom, lengthTo, width, thickness, muAbbrv);
		                    productSizesList.add(product);
	                }
					} catch (SQLException e) {
						e.printStackTrace();
					}
	        return productSizesList;
	}
	 
	 public static List<ProductPrice> selectProductPrices(Connection conn) {
		 List<ProductPrice> productPricesList = new ArrayList<ProductPrice>();
		 Statement statement;
		try {
				statement = conn.createStatement();
			
	         ResultSet resultSet = statement.executeQuery("SELECT * FROM product_price");
	         while(resultSet.next()){
	        	 String sizedProductId = resultSet.getString(1);
	        	 Date priceDate = resultSet.getDate(2);
	        	 double price = resultSet.getDouble(3);
	        	 ProductPrice productPrice = new ProductPrice(sizedProductId, priceDate, price);
	        	 productPricesList.add(productPrice);
         }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productPricesList;
	}
	 
	 public static ProductPrice findProductPrice(Connection conn, String id)  {
		 		String sql = "Select * from product_price where sized_product_id = ?";
	 		try (PreparedStatement pstm = conn.prepareStatement(sql)){
				 pstm.setString(1, id);
				 ResultSet rs = pstm.executeQuery();
				 while (rs.next()) {
				 String sizedProductId = rs.getString(1);
				 Date priceDate = rs.getDate(2);
				 				double price = rs.getFloat(3);
				 ProductPrice productPrice = new ProductPrice(sizedProductId, priceDate, price);
				 return productPrice;
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return null;
	}
	 
	 public static void updateProductPrice(Connection conn, String sizedProductId, double price) {
		 	String sql = "Update product_price set price = ? where sized_product_id =? ";
		 	PreparedStatement pstm;
			try {
					pstm = conn.prepareStatement(sql);
		        pstm.setDouble(1, price);
		        pstm.setString(2, sizedProductId);
		        pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	 
	 public static void deleteProductPrice(Connection conn, String sizedProductId) {
		 	String sql = "delete from product_price where sized_product_id =?";
		 	PreparedStatement pstm;
			try {
				pstm = conn.prepareStatement(sql);
		        pstm.setString(1, sizedProductId);
		        pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	 
	 public static List<Order> selectOrders(Connection conn) {
		 List<Order> ordersList = new ArrayList<Order>();
		try(Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM _order");
			while(resultSet.next()){
				int orderId = resultSet.getInt(1);
				String сustomerName = resultSet.getString(2);
				String customerPhone = resultSet.getString(3);
				String сustomerEmail = resultSet.getString(4);
                String orderInfo = resultSet.getString(5);
                Timestamp orderDate = resultSet.getTimestamp(6);
                Order order = new Order(orderId, сustomerName, customerPhone, сustomerEmail, orderInfo, orderDate);
                ordersList.add(order);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}
	 
	 public static void updateOrder(Connection conn, Order order) {
		 	String sql = "Update _order set customer_name = ?, customer_phone = ?, customer_email = ?, order_info = ? "
		 			+ "where order_id =? ";
			try(PreparedStatement pstm = conn.prepareStatement(sql)) {
		        pstm.setString(1, order.getCustomerName());
		        pstm.setString(2, order.getCustomerPhone());
		        pstm.setString(3, order.getCustomerEmail());
		        pstm.setString(4, order.getOrderInfo());
		        pstm.setInt(5, order.getOrderId());
		        pstm.executeUpdate();
			}
	        catch (SQLException e) {
				e.printStackTrace();
			}
	}
	 
	 public static void deleteOrder(Connection conn, int id) {
		 	String sql = "delete from _order where order_id =?";
			try(PreparedStatement pstm = conn.prepareStatement(sql)) {
		        pstm.setInt(1, id);
		        pstm.executeUpdate();
			}
	        catch (SQLException e) {
				e.printStackTrace();
			}
	}
	 

	public static Order findOrder(Connection conn, int id) {
		String sql = "Select * from _order where order_id = ?";
		Order order = null;
		try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int orderId = resultSet.getInt(1);
                String customerName = resultSet.getString(2);
                String customerPhone = resultSet.getString(3);
                String customerEmail = resultSet.getString(4);
                String orderInfo = resultSet.getString(5);
                Timestamp orderDate = resultSet.getTimestamp(6);
                order = new Order(orderId, customerName, customerPhone ,customerEmail, orderInfo, orderDate);
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	 
}
