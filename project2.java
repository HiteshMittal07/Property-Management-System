import java.util.*;

import javax.lang.model.util.ElementScanner14;

import java.math.BigInteger;
import java.sql.*;
import java.sql.Date;

public class project2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "hm@11759");
        System.out.println("WELCOME!!");
        System.out.println("1) Login as buyer");
        System.out.println("2) Login as seller");
        System.out.println("3) Login as user");
        System.out.println("4) Exit");
        int d;
        Scanner input = new Scanner(System.in);
        d = input.nextInt();
        Statement stmt = connection.createStatement();
        switch (d) {
            case 1:
                System.out.println("Enter your Buyer ID here:");
                int buyer_id = input.nextInt();
                System.out.println("Enter your password here:");
                input.nextLine();
                String password = input.nextLine();
                while (true) {
                    String q2 = "select * from loginsystem where id='" + buyer_id + "'and password='" + password + "' and role='buyer'";
                    ResultSet rs = stmt.executeQuery(q2);
                    if (!rs.next()) {
                        System.out.println("Buyer id not exist!!");
                        System.out.println("Enter again!");
                        System.out.println("Enter your Buyer ID here:");
                        buyer_id = input.nextInt();
                        System.out.println("Enter your password here:");
                        input.nextLine();
                        password = input.nextLine();
                    } else {
                        break;
                    }
                }
                System.out.println("LOGIN SUCCESSFULLY!!!");
                System.out.println("SEARCH PROPERTY ACCORDING TO YOUR PREFERENCES!!!");
                System.out.println("Enter preference:");
                String preference = input.nextLine();
                if (preference.compareTo("rent") == 0) {
                    System.out.println("Enter 1 to filter properties:");
                    int g = input.nextInt();
                    if (g == 1) {
                        System.out.println("Enter your budget:");
                        int budget = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter specific city:");
                        String prefercity = input.nextLine();
                        System.out.println("Enter specific locality:");
                        String locality = input.nextLine();

                        String query8 = "select * from property where rent_price<='" + budget + "' and city='"
                                + prefercity + "' and street_address='" + locality + "' and buy_rent='rent'";
                        ResultSet result = stmt.executeQuery(query8);
                        while (result.next()) {
                            System.out.print("propertyid: " + result.getInt("propertyid"));
                            System.out.print(", area: " + result.getInt("area"));
                            System.out.print(", city: " + result.getString("city"));
                            System.out.print(", pincode: " + result.getInt("pincode"));
                            System.out.print(", street_address: " + result.getString("street_address"));
                            System.out.print(", no_of_rooms: " + result.getInt("no_of_rooms"));
                            System.out.print(", buy_rent: " + result.getString("buy_rent"));
                            System.out.print(", buy_price: " + result.getInt("buy_price"));
                            System.out.print(", rent_price: " + result.getInt("rent_price"));
                            System.out.print(", build_date: " + result.getInt("build_date"));
                            System.out.println(", availabilty_status: " + result.getString("availabilty_status"));
                        }

                    } else {
                        String query7 = "select * from property where buy_rent='rent'";
                        ResultSet result = stmt.executeQuery(query7);
                        while (result.next()) {
                            System.out.print("propertyid: " + result.getInt("propertyid"));
                            System.out.print(", area: " + result.getInt("area"));
                            System.out.print(", city: " + result.getString("city"));
                            System.out.print(", pincode: " + result.getInt("pincode"));
                            System.out.print(", street_address: " + result.getString("street_address"));
                            System.out.print(", no_of_rooms: " + result.getInt("no_of_rooms"));
                            System.out.print(", buy_rent: " + result.getString("buy_rent"));
                            System.out.print(", buy_price: " + result.getInt("buy_price"));
                            System.out.print(", rent_price: " + result.getInt("rent_price"));
                            System.out.print(", build_date: " + result.getInt("build_date"));
                            System.out.println(", availabilty_status: " + result.getString("availabilty_status"));
                        }
                    }
                } else if (preference.compareTo("buy") == 0) {
                    System.out.println("Enter 1 to filter properties:");
                    int h = input.nextInt();
                    if (h == 1) {
                        System.out.println("Enter your budget:");
                        int budget1 = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter specific city:");
                        String prefercity1 = input.nextLine();
                        System.out.println("Enter specific locality:");
                        String locality1 = input.nextLine();

                        String query12 = "select * from property where buy_price<='" + budget1 + "' and city='"
                                + prefercity1 + "' and street_address='" + locality1 + "' and buy_rent='buy'";
                        ResultSet result = stmt.executeQuery(query12);
                        while (result.next()) {
                            System.out.print("propertyid: " + result.getInt("propertyid"));
                            System.out.print(", area: " + result.getInt("area"));
                            System.out.print(", city: " + result.getString("city"));
                            System.out.print(", pincode: " + result.getInt("pincode"));
                            System.out.print(", street_address: " + result.getString("street_address"));
                            System.out.print(", no_of_rooms: " + result.getInt("no_of_rooms"));
                            System.out.print(", buy_rent: " + result.getString("buy_rent"));
                            System.out.print(", buy_price: " + result.getInt("buy_price"));
                            System.out.print(", rent_price: " + result.getInt("rent_price"));
                            System.out.print(", build_date: " + result.getInt("build_date"));
                            System.out.println(", availabilty_status: " + result.getString("availabilty_status"));
                        }

                    } else {
                        String query11 = "select * from property where buy_rent='buy'";
                        ResultSet result = stmt.executeQuery(query11);
                        while (result.next()) {
                            System.out.print("propertyid: " + result.getInt("propertyid"));
                            System.out.print(", area: " + result.getInt("area"));
                            System.out.print(", city: " + result.getString("city"));
                            System.out.print(", pincode: " + result.getInt("pincode"));
                            System.out.print(", street_address: " + result.getString("street_address"));
                            System.out.print(", no_of_rooms: " + result.getInt("no_of_rooms"));
                            System.out.print(", buy_rent: " + result.getString("buy_rent"));
                            System.out.print(", buy_price: " + result.getInt("buy_price"));
                            System.out.print(", rent_price: " + result.getInt("rent_price"));
                            System.out.print(", build_date: " + result.getInt("build_date"));
                            System.out.println(", availabilty_status: " + result.getString("availabilty_status"));
                        }
                    }
                } else {
                    System.out.println("Enter 1 to filter properties:");
                    int l = input.nextInt();
                    if (l == 1) {
                        System.out.println("Enter your budget:");
                        int budget2 = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter specific city:");
                        String prefercity2 = input.nextLine();
                        System.out.println("Enter specific locality:");
                        String locality2 = input.nextLine();

                        String query12 = "select * from property where buy_price<='" + budget2 + "' and city='"
                                + prefercity2 + "' and street_address='" + locality2 + "' and buy_rent='both'";
                        ResultSet result = stmt.executeQuery(query12);
                        while (result.next()) {
                            System.out.print("propertyid: " + result.getInt("propertyid"));
                            System.out.print(", area: " + result.getInt("area"));
                            System.out.print(", city: " + result.getString("city"));
                            System.out.print(", pincode: " + result.getInt("pincode"));
                            System.out.print(", street_address: " + result.getString("street_address"));
                            System.out.print(", no_of_rooms: " + result.getInt("no_of_rooms"));
                            System.out.print(", buy_rent: " + result.getString("buy_rent"));
                            System.out.print(", buy_price: " + result.getInt("buy_price"));
                            System.out.print(", rent_price: " + result.getInt("rent_price"));
                            System.out.print(", build_date: " + result.getInt("build_date"));
                            System.out.println(", availabilty_status: " + result.getString("availabilty_status"));
                        }
                    } else {
                        String q1 = "select * from property where buy_rent='both'";
                        ResultSet result = stmt.executeQuery(q1);
                        while (result.next()) {
                            System.out.print("propertyid: " + result.getInt("propertyid"));
                            System.out.print(", area: " + result.getInt("area"));
                            System.out.print(", city: " + result.getString("city"));
                            System.out.print(", pincode: " + result.getInt("pincode"));
                            System.out.print(", street_address: " + result.getString("street_address"));
                            System.out.print(", no_of_rooms: " + result.getInt("no_of_rooms"));
                            System.out.print(", buy_rent: " + result.getString("buy_rent"));
                            System.out.print(", buy_price: " + result.getInt("buy_price"));
                            System.out.print(", rent_price: " + result.getInt("rent_price"));
                            System.out.print(", build_date: " + result.getInt("build_date"));
                            System.out.println(", availabilty_status: " + result.getString("availabilty_status"));
                        }
                    }
                }
                System.out.println("Enter property ID of property you want to buy:");
                int pID = input.nextInt();

                while(true)
                {
                    String q27 = "select * from property where propertyid='" + pID + "'and availabilty_status='yes'";
                    ResultSet rs = stmt.executeQuery(q27);
                    if (!rs.next()) {
                        System.out.println("property already sold!!");
                        System.out.println("Enter again!");
                        System.out.println("Enter property ID of property you want to buy:");
                        pID = input.nextInt(); 
                    } else {
                        System.out.println("Successfully pruchased!!");
                        String query65="update property set availabilty_status='no' where propertyid='"+pID+"'";
                        stmt.executeUpdate(query65);
                        break;
                    }

                }
                String q5 = "select * from property_relation where propertyid='" + pID + "'";
                ResultSet result = stmt.executeQuery(q5);
                int aId = 0;
                while (result.next()) {
                    aId = result.getInt("agent_id");
                }
                String q6 = "insert into buyer_relation values('" + buyer_id + "','" + aId + "')";
                stmt.executeUpdate(q6);
                String q7 = "select ownerid from owner_relation where propertyid='" + pID + "'";
                ResultSet result1 = stmt.executeQuery(q7);
                int oId = 0;
                while (result1.next()) {
                    oId = result1.getInt("ownerid");
                }
                String q8 = "insert into owner_agent_relation values('" + oId + "','" + aId + "')";
                stmt.executeUpdate(q8);

                input.nextLine();
                System.out.println("Enter date of transaction:");
                String dateoftr = input.nextLine();

                String q9 = "select * from property where propertyid='" + pID + "'";
                ResultSet result2 = stmt.executeQuery(q9);
                String buyrent1 = null;
                int bp = 0;
                int rp = 0;
                while (result2.next()) {
                    buyrent1 = result2.getString("buy_rent");
                    bp = result2.getInt("buy_price");
                    rp = result2.getInt("rent_price");
                }
                String q11 = "insert into transaction values('" + aId + "','" + buyer_id + "','" + oId + "','" + pID
                        + "','" + dateoftr + "','" + buyrent1 + "','" + bp + "','" + rp + "')";
                stmt.executeUpdate(q11);

                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();

                connection.close();
                break;
            case 2:
                System.out.println("Enter your Seller ID here:");
                int ownerid = input.nextInt();
                System.out.println("Enter your password here:");
                input.nextLine();
                String password11 = input.nextLine();
                String city1 = null;
                int pincode1 = 0;
                String email_id1 = null;
                BigInteger phone1 = null;
                String owner_name = null;
                int count = 0;
                while (true) {
                    String q22 = "select * from loginsystem where id='" + ownerid + "'and password='" + password11
                            + "' and role='seller'";
                    ResultSet rs = stmt.executeQuery(q22);
                    if (!rs.next()) {
                        System.out.println("Seller id not exist!!");
                        System.out.println("Enter your details to SIGN UP:");
                        System.out.println("Enter your name:");
                        owner_name = input.nextLine();
                        System.out.println("Enter ownerid:");
                        ownerid = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter city:");
                        city1 = input.nextLine();
                        System.out.println("Enter pincode:");
                        pincode1 = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter email_id:");
                        email_id1 = input.nextLine();
                        System.out.println("Enter phone:");
                        phone1 = input.nextBigInteger();
                        input.nextLine();
                        System.out.println("Enter your password here:");
                        password11 = input.nextLine();
                        count++;
                        break;
                    } else {
                        break;
                    }
                }
                if (count == 0) {
                    break;
                }
                System.out.println("Done!! Now Enter your property details->");

                System.out.println("Enter propertyid:");
                int propertyid = input.nextInt();
                System.out.println("Enter area(in sq.ft):");
                int area = input.nextInt();
                input.nextLine();
                System.out.println("Enter city:");
                String city2 = input.nextLine();
                System.out.println("Enter pincode:");
                int pincode2 = input.nextInt();
                input.nextLine();
                System.out.println("Enter street_address:");
                String street_adress = input.nextLine();
                System.out.println("Enter number of rooms:");
                int no_ofrooms = input.nextInt();
                input.nextLine();
                System.out.println("Enter the property available for buy/rent or both:");
                String buy_rent = input.nextLine();
                int buy_price = 0;
                int rent_price = 0;
                if (buy_rent.compareTo("buy") == 0) {
                    System.out.println("Enter buy price:");
                    buy_price = input.nextInt();
                } else if (buy_rent.compareTo("rent") == 0) {
                    System.out.println("Enter rent price:");
                    rent_price = input.nextInt();
                } else {
                    System.out.println("Enter buy price:");
                    buy_price = input.nextInt();
                    System.out.println("Enter rent price:");
                    rent_price = input.nextInt();
                }
                System.out.println("Enter build date:");
                int build_date = input.nextInt();
                input.nextLine();
                System.out.println("Enter availabilty status:");
                String availabilty_status = input.nextLine();

                String query2 = "INSERT INTO owner VALUES('" + ownerid + "', '" + owner_name + "','" + city1 + "','"
                        + pincode1 + "','" + email_id1 + "','" + phone1 + "')";
                stmt.executeUpdate(query2);
                String query3 = "INSERT INTO property VALUES('" + propertyid + "', '" + area + "', '" + city2 + "', '"
                        + pincode2 + "','" + street_adress + "','" + no_ofrooms + "','" + buy_rent + "','" + buy_price
                        + "','" + rent_price + "','" + build_date + "','" + availabilty_status + "')";
                stmt.executeUpdate(query3);
                String query4 = "insert into owner_relation values('" + ownerid + "','" + propertyid + "')";
                stmt.executeUpdate(query4);
                String query6 = "insert into loginsystem values('" + ownerid + "','" + password11
                        + "','seller')";
                stmt.executeUpdate(query6);
                stmt.close();
                stmt.close();
                stmt.close();
                stmt.close();
                connection.close();

            case 3:
                System.out.println("Enter your User ID here:");
                int user_id = input.nextInt();
                System.out.println("Enter your password here:");
                input.nextLine();
                String password23 = input.nextLine();
                while (true) {
                    String q2 = "select * from loginsystem where id='" + user_id + "'and password='" + password23 + "' and role='user'";
                    ResultSet rs = stmt.executeQuery(q2);
                    if (!rs.next()) {
                        System.out.println("User id not exist!!");
                        System.out.println("Enter again!");
                        System.out.println("Enter your User ID here:");
                        user_id = input.nextInt();
                        System.out.println("Enter your password here:");
                        input.nextLine();
                        password23 = input.nextLine();
                    } else {
                        break;
                    }
                }
                System.out.println("LOGIN SUCCESSFULLY!!!");
                System.out.println("1)agent:");
                System.out.println("2)buyer:");
                System.out.println("3)seller:");
                System.out.println("4)property:");
                System.out.println("5)transaction:");
                System.out.println("Select the table from above for which you want to run your query:");
                int u = input.nextInt();
                input.nextLine();
                System.out.println("Enter your query:");
                String query76 = input.nextLine();
                ResultSet result8 = stmt.executeQuery(query76);
                switch (u) {
                    case 1:
                        while(result8.next())
                        {
                            System.out.print("agent_name: " + result8.getString("agent_name"));
                            System.out.print(", agent_id: " + result8.getInt("agent_id"));
                            System.out.print(", contact: " + result8.getBigDecimal("contact"));
                            System.out.print(", address: " + result8.getString("address"));
                            System.out.println(", mail_id: " + result8.getString("mail_id"));
                        }
                        break;
                    case 2:
                        while(result8.next())
                        {
                            System.out.print("buyerid: " + result8.getInt("buyerid"));
                            System.out.print(", buyer_name: " + result8.getString("buyer_name"));
                            System.out.print(", city: " + result8.getString("city"));
                            System.out.print(", pincode: " + result8.getInt("pincode"));
                            System.out.print(", mail_id: " + result8.getString("emailid"));
                            System.out.println(", contact: " + result8.getInt("contact"));
                        }
                        break;
                    case 3:
                        while(result8.next())
                        {
                            System.out.print("ownerid: " + result8.getInt("ownerid"));
                            System.out.print(", owner_name: " + result8.getString("owner_name"));
                            System.out.print(", city: " + result8.getString("city"));
                            System.out.print(", pincode: " + result8.getInt("pincode"));
                            System.out.print(", mail_id: " + result8.getString("emailid"));
                            System.out.println(", contact: " + result8.getInt("contact"));
                        }
                        break;        
                    case 4:
                        while (result8.next()) {
                            System.out.print("propertyid: " + result8.getInt("propertyid"));
                            System.out.print(", area: " + result8.getInt("area"));
                            System.out.print(", city: " + result8.getString("city"));
                            System.out.print(", pincode: " + result8.getInt("pincode"));
                            System.out.print(", street_address: " + result8.getString("street_address"));
                            System.out.print(", no_of_rooms: " + result8.getInt("no_of_rooms"));
                            System.out.print(", buy_rent: " + result8.getString("buy_rent"));
                            System.out.print(", buy_price: " + result8.getInt("buy_price"));
                            System.out.print(", rent_price: " + result8.getInt("rent_price"));
                            System.out.print(", build_date: " + result8.getInt("build_date"));
                            System.out.println(", availabilty_status: " + result8.getString("availabilty_status"));
                        }
                        break;
                    case 5:
                        while(result8.next())
                        {
                            System.out.print("agent_id: " + result8.getInt("agent_id"));
                            System.out.print(", buyerid: " + result8.getInt("buyerid"));
                            System.out.print(", ownerid: " + result8.getInt("ownerid"));
                            System.out.print(", propertyid: " + result8.getInt("propertyid"));
                            System.out.print(", date_of_transaction: " + result8.getString("date_of_transaction"));
                            System.out.print(", buy_rent: " + result8.getString("buy_rent"));
                            System.out.print(", buy_price: " + result8.getInt("buy_price"));
                            System.out.println(", rent_price: " + result8.getInt("rent_price"));
                        }

                }
            case 4:
                break;    
        }

    }
}
