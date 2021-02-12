package org.launchcode.techjobs_oo.Tests;
import org.junit.Assert;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import org.junit.Before;

public class JobTest {

    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob3B;

    @Before
    public void createJobObject(){
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob3B = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        Assert.assertEquals(1,testJob2.getId() - testJob1.getId());
    }

    @Test
    public void testJobConstructorSetAllFields(){
        Assert.assertEquals("Product tester",testJob3.getName());
        Assert.assertEquals("ACME", testJob3.getEmployer().getValue());
        Assert.assertEquals("Desert", testJob3.getLocation().getValue());
        Assert.assertEquals("Quality control", testJob3.getPositionType().getValue());
        Assert.assertEquals("Persistence", testJob3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Assert.assertNotEquals(testJob3,testJob3B);
    }
}
