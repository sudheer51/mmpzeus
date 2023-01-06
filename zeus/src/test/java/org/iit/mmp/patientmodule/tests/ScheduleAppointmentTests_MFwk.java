package org.iit.mmp.patientmodule.tests;
import java.util.HashMap;
import org.iit.mmp.patientmodule.pages.HomePage;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.mmp.util.BaseClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
public class ScheduleAppointmentTests_MFwk extends BaseClass{
	@Test
	public void validateBookAppointment()
	{ 
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(pro.getProperty("patientUserName"),pro.getProperty("patientPassword"));
		HomePage homePage = new HomePage(driver);
		homePage.navigateToAModule("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap =sPage.bookAppointment("Smith",Integer.parseInt(pro.getProperty("futureDate")));
		HashMap<String,String> actualHMap = homePage.fetchAppointmentDetails();
		AssertJUnit.assertEquals(actualHMap, expectedHMap);
	}
}






/**
 * 1. Open the browser and login to the MMP
 * 2. Click on ScheduleAppointment Tab
 * 3. Click on "create new appointment" button
 * 4. Select the doctor and click on "book appointment" button
 * 5. Select the future date from date picker : 30 days from now
 * 6. Select the time as "10 Am"
 * 7. Click on continue button
 * 8. Enter the text in the textbox
 * 9. Click on submit button
 * 10. Validate the details entered during the appointment are added to the Patient Portal table 
 * 	   as a first row in the Home  page.
 */