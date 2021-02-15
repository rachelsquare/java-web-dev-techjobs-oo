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
    Job testJob3C;

    @Before
    public void createJobObject(){
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob3B = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob3C = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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


    String testJob3String;
    String testJob3CString;


    @Before
    public void createTestJobStrings(){
        testJob3String = testJob3.toString();
        testJob3CString = testJob3C.toString();
    }

    // ****
    @Test
    public void testToStringFirstLastLines(){
        String [] lines = testJob3String.split("\n");
        String line1 = lines[0];
        String lastLine = lines[lines.length-1];
        Assert.assertEquals(" ", line1);
        Assert.assertEquals(" ", lastLine);
    }

    @Test
    public void testToStringContainsFieldLabels(){
        String expectedString = " \nID: " + testJob3.getId() + "\nName: " + testJob3.getName()
                +"\nEmployer: " + testJob3.getEmployer() + "\nLocation " + testJob3.getLocation() +
                "\nPosition Type: " + testJob3.getPositionType() + "\nCore Competency: " + testJob3.getCoreCompetency() + "\n ";
        Assert.assertEquals(testJob3String,expectedString);
    }

    @Test
    public void testToStringNoData(){
        String expectedString = " \nID: " + testJob3C.getId() + "\nName: " + testJob3C.getName()
                +"\nEmployer: Data not available" + "\nLocation " + testJob3C.getLocation() +
                "\nPosition Type: " + testJob3C.getPositionType() + "\nCore Competency: " + testJob3C.getCoreCompetency()+"\n ";
        Assert.assertEquals(testJob3CString,expectedString);
    }
}
