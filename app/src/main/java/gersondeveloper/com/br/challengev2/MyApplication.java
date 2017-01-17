package gersondeveloper.com.br.challengev2;

import android.app.Application;

import com.facebook.stetho.Stetho;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by gerso on 12/30/2016.
 */

public class MyApplication extends Application {

    public Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        //Initialize Realm
        Realm.init(this);

        /*RealmConfiguration realmConfig = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfig);
*/
        Stetho.initializeWithDefaults(this);
    }
}
