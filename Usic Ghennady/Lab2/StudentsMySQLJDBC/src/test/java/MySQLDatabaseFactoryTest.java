import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Ghennady
 * Date: 10/31/12
 * Time: 8:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class MySQLDatabaseFactoryTest {
    @Test
    public void testConnect() throws Exception {
        assertNotNull(new MySQLDatabaseFactory().connect("jdbc:mysql://localhost/students", "root", "Minamino7"));
    }
}
