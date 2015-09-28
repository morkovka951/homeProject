import Connect.connect;

import java.sql.Connection;

/**
 * Created by Morkva on 27.09.2015.
 */
public class main {

    public static void main(String[] args) {

        connect connn = new connect();
        connn.conn();
        connn.names();



    }

}
