package time;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	
	//milliseconds
	@Test
	void testGetMilliseconds() {
		int milliseconds = Time.getMilliseconds("12:05:05:05");
		assertTrue("The milliseconds have been calculated properly: ", milliseconds == 5);
	}

	// Seconds 
    @Test
    void testGetTotalSecondsGood() {
    	int seconds = Time.getTotalSeconds("05:05:05:00");
    	assertTrue("The seconds were calculated properly", seconds == 18305);
        }
    
    @Test
    public void testGetTotalSecondsBad(){
    	assertThrows(StringIndexOutOfBoundsException.class,
    			()-> {Time.getTotalSeconds("10:00");});
    	}
    
    @Test
    public void testGetTotalSecondsBoundry() {
    	int seconds = Time.getTotalSeconds("00:00:00:00");
    	assertTrue("The seconds should be 0", seconds == 0);
    	}
    
    //Minutes
    @Test
    public void testGetTotalMinutesGood() {
    	int minutes = Time.getTotalMinutes("05:15:20:00");
    	assertTrue("The minutes were calculated properly", minutes == 15);
    }
    
    @Test
    public void testGetTotalMinutesBad() {
    	assertThrows(StringIndexOutOfBoundsException.class,
    			()-> {Time.getTotalMinutes("10:");});
    	}

    @Test
    public void testGetTotalMinutesBoundry() {
    	int minutes = Time.getTotalMinutes("05:00:50:00");
    	assertTrue("The minutes were calculated properly", minutes == 00);
    }
    
    //Hours
    @ParameterizedTest
    @ValueSource(strings = { "05:00:00:00" , "05:15:15:00", "05:59:59:00" } ) 
    void testGetTotalHours(String hours) {
    	int calHours = Time.getTotalHours(hours);
    	assertTrue("The hours were not calculated properly", calHours ==5);
    	}
    }

