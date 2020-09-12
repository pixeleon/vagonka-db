package net.pixeleon.khpi.vagonkadb.utils;

import net.pixeleon.khpi.vagonkadb.beans.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBUtils {
    public static List<CustomerPrice> selectCustomerPrices(Connection conn) throws SQLException {
        List<CustomerPrice> customerPricesList = new ArrayList<CustomerPrice>();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer_price_info");
        while (resultSet.next()) {
            String productTypeName = resultSet.getString(1);
            String woodTypeName = resultSet.getString(2);
            String woodKindName = resultSet.getString(3);
            double lengthFrom = resultSet.getDouble(4);
            double lengthTo = resultSet.getDouble(5);
            double width = resultSet.getDouble(6);
            double thickness = resultSet.getDouble(7);
            String muAbbrv = resultSet.getString(8);
            double price = resultSet.getDouble(9);
            CustomerPrice product = new CustomerPrice(productTypeName, woodTypeName, woodKindName,
                    lengthFrom, lengthTo, width, thickness, muAbbrv, price);
            customerPricesList.add(product);
        }
        return customerPricesList;
    }

    public static List<ProductInfo> selectProducts(Connection conn) {
        List<ProductInfo> productList = new ArrayList<ProductInfo>();
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product_info");
            while (resultSet.next()) {
                int productId = resultSet.getInt(1);
                String productTypeName = resultSet.getString(2);
                String woodTypeName = resultSet.getString(3);
                String woodKindName = resultSet.getString(4);
                String muAbbrv = resultSet.getString(5);
                ProductInfo product = new ProductInfo(productId, productTypeName, woodTypeName, woodKindName, muAbbrv);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public static List<ProductSizeInfo> selectSizedProducts(Connection conn) {
        List<ProductSizeInfo> productSizesList = new ArrayList<ProductSizeInfo>();
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sized_product_info");
            while (resultSet.next()) {
                String sizedProductId = resultSet.getString(1);
                String productTypeName = resultSet.getString(2);
                String woodTypeName = resultSet.getString(3);
                String woodKindName = resultSet.getString(4);
                double lengthFrom = resultSet.getDouble(5);
                double lengthTo = resultSet.getDouble(6);
                double width = resultSet.getDouble(7);
                double thickness = resultSet.getDouble(8);
                String muAbbrv = resultSet.getString(9);
                ProductSizeInfo product = new ProductSizeInfo(sizedProductId, productTypeName, woodTypeName,
                        woodKindName, lengthFrom, lengthTo, width, thickness, muAbbrv);
                productSizesList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productSizesList;
    }

    public static List<ManagerPrice> selectManagerPrices(Connection conn) {
        List<ManagerPrice> managerPricesList = new ArrayList<ManagerPrice>();
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM manager_price_info");
            while (resultSet.next()) {
                int sizedProductId = resultSet.getInt(1);
                String productTypeName = resultSet.getString(2);
                String woodTypeName = resultSet.getString(3);
                String woodKindName = resultSet.getString(4);
                double lengthFrom = resultSet.getDouble(5);
                double lengthTo = resultSet.getDouble(6);
                double width = resultSet.getDouble(7);
                double thickness = resultSet.getDouble(8);
                String muAbbrv = resultSet.getString(9);
                double price = resultSet.getDouble(10);
                Date priceDate = resultSet.getDate(11);
                int amount = resultSet.getInt(12);
                ManagerPrice product = new ManagerPrice(sizedProductId, productTypeName, woodTypeName, woodKindName,
                        lengthFrom, lengthTo, width, thickness, muAbbrv, price, priceDate, amount);
                managerPricesList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return managerPricesList;
    }

    public static List<SizedProductPrice> selectProductPrices(Connection conn) {
        List<SizedProductPrice> productPricesList = new ArrayList<SizedProductPrice>();
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sized_product_price");
            while (resultSet.next()) {
                int sizedProductId = resultSet.getInt(1);
                Date priceDate = resultSet.getDate(2);
                double price = resultSet.getDouble(3);
                int amount = resultSet.getInt(4);
                SizedProductPrice productPrice = new SizedProductPrice(sizedProductId, priceDate, price, amount);
                productPricesList.add(productPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productPricesList;
    }

    public static SizedProductPrice findProductPrice(Connection conn, int id) {
        String sql = "Select * from sized_product_price where sized_product_id = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int sizedProductId = rs.getInt(1);
                Date priceDate = rs.getDate(2);
                double price = rs.getFloat(3);
                int amount = rs.getInt(4);
                return new SizedProductPrice(sizedProductId, priceDate, price, amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateProductPrice(Connection conn, String sizedProductId, double price, int amount) {

        String sql = "Update sized_product_price set price = ?, amount = ? where sized_product_id =? ";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, price);
            pstm.setInt(2, amount);
            pstm.setString(3, sizedProductId);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProductPrice(Connection conn, String sizedProductId) {
        String sql = "delete from sized_product_price where sized_product_id =?";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, sizedProductId);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Order> selectOrders(Connection conn) throws SQLException {
        List<Order> ordersList = new ArrayList<Order>();
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM _order");
            while (resultSet.next()) {
                int orderId = resultSet.getInt(1);
                String customerName = resultSet.getString(2);
                String customerPhone = resultSet.getString(3);
                String customerEmail = resultSet.getString(4);
                String orderInfo = resultSet.getString(5);
                Timestamp orderDate = resultSet.getTimestamp(6);
                Order order = new Order(orderId, customerName, customerPhone, customerEmail, orderInfo, orderDate);
                ordersList.add(order);
            }
        }
        return ordersList;
    }

    public static void insertOrder(Connection conn, Order order) throws SQLException {
        String sql = "call sp_order_ops ('i',-1,?,?,?,?,null)";
        try (CallableStatement cstm = conn.prepareCall(sql)) {
            cstm.setString(1, order.getCustomerName());
            cstm.setString(2, order.getCustomerPhone());
            cstm.setString(3, order.getCustomerEmail());
            cstm.setString(4, order.getOrderInfo());
            cstm.execute();
        }
    }

    public static void updateOrder(Connection conn, Order order) throws SQLException {
        String sql = "call sp_order_ops ('u',?,?,?,?,?,null)";
        try (CallableStatement cstm = conn.prepareCall(sql)) {
            cstm.setInt(1, order.getOrderId());
            cstm.setString(2, order.getCustomerName());
            cstm.setString(3, order.getCustomerPhone());
            cstm.setString(4, order.getCustomerEmail());
            cstm.setString(5, order.getOrderInfo());
            cstm.execute();
        }
    }

    public static void deleteOrder(Connection conn, int id) throws SQLException {
        String sql = "call sp_order_ops ('d',?,'','','','',null)";
        try (CallableStatement cstm = conn.prepareCall(sql)) {
            cstm.setInt(1, id);
            cstm.executeUpdate();
        }
    }

    public static Order findOrder(Connection conn, int id) throws SQLException {
        String sql = "select * from _order where order_id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int orderId = resultSet.getInt(1);
            String customerName = resultSet.getString(2);
            String customerPhone = resultSet.getString(3);
            String customerEmail = resultSet.getString(4);
            String orderInfo = resultSet.getString(5);
            Timestamp orderDate = resultSet.getTimestamp(6);
            return new Order(orderId, customerName, customerPhone, customerEmail, orderInfo, orderDate);
        }
        return null;
    }

    public static ProductSizeInfo findSizedProduct(Connection conn, String id) {
        String sql = "select * from product_size_info where sized_product_id = ?";
        ProductSizeInfo sizedProduct = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String sizedProductId = resultSet.getString(1);
                String productTypeName = resultSet.getString(2);
                String woodTypeName = resultSet.getString(3);
                String woodKindName = resultSet.getString(4);
                double lengthFrom = resultSet.getDouble(5);
                double lengthTo = resultSet.getDouble(6);
                double width = resultSet.getDouble(7);
                double thickness = resultSet.getDouble(8);
                String muAbbrv = resultSet.getString(9);
                sizedProduct = new ProductSizeInfo(sizedProductId, productTypeName, woodTypeName,
                        woodKindName, lengthFrom, lengthTo, width, thickness, muAbbrv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizedProduct;
    }

    public static void updateSizedProduct(Connection conn, String spId, double lengthFrom, double lengthTo, double width,
                                          double thickness) {
        String sql = "update sized_product set length_from = ?, length_to = ?, width = ?, thickness = ?"
                + " where sized_product_id = ?";
        try (PreparedStatement prstm = conn.prepareStatement(sql)) {
            prstm.setDouble(1, lengthFrom);
            prstm.setDouble(2, lengthTo);
            prstm.setDouble(3, width);
            prstm.setDouble(4, thickness);
            prstm.setString(5, spId);
            int r = prstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
