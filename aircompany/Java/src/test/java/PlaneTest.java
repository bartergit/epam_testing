import entity.model.MilitaryType;
import entity.plane.MilitaryPlane;
import entity.plane.PassengerPlane;
import entity.plane.Plane;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaneTest {
    private List<Plane> planeList;
    private List<String> expected;

    @BeforeTest
    private void setUp() {
        planeList = Arrays.asList(new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER));
        expected = Arrays.asList("Bombardier CS300", "B-1B Lancer");
    }

    @Test
    public void testGetModel() {
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(planeList.get(i).getModel(), expected.get(i));
        }
    }
}
