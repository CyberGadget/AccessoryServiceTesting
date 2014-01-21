package edu.rosehulman.accessoryservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class AccessoryServiceActivity extends Activity {
    /** Called when the activity is first created. */
    
    private String TAG = "AccessoryServiceActivity";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.d(TAG, "onCreate entered");

        Intent thisIntent = getIntent();
        Intent passIntent = new Intent(this, AccessoryService.class);
        passIntent.putExtras(thisIntent);
        //intent.fillIn(getIntent(), 0); // TODO: Find better way to get extras for `UsbManager.getAccessory()` use?
        startService(passIntent);
        
		
        // See:
        //
        //    <http://permalink.gmane.org/gmane.comp.handhelds.android.devel/154481> &
        //    <http://stackoverflow.com/questions/5567312/android-how-to-execute-main-fucntionality-of-project-only-by-clicking-on-the-ic/5567514#5567514>
        //
        // for combination of `Theme.NoDisplay` and `finish()` in `onCreate()`/`onResume()`.
        //
        // finish(); //Exits Activity
		
        Log.d(TAG, "onCreate exited");
    }
}
