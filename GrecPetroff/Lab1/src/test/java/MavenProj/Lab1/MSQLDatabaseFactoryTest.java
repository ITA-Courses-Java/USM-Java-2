package MavenProj.Lab1;

import static org.junit.Assert.assertNotNull;

import org.junit.*;


public class MSQLDatabaseFactoryTest {
    @Test
    public void testConnect() throws Exception {
        new MSQLDatabaseFactory();
		assertNotNull(MSQLDatabaseFactory.connect("root", "2hungry"));
    }
}
