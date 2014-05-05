package com.kaissersoft.missrepdom.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.kaissersoft.missrepdom.persistence.Contracts.ModelsContract;
import com.kaissersoft.missrepdom.persistence.Contracts.ModelsImagesContract;
import com.kaissersoft.missrepdom.persistence.Contracts.UserPreferencesContract;
import com.tjeannin.provigen.ProviGenProvider;
import com.tjeannin.provigen.helper.TableBuilder;
import com.tjeannin.provigen.helper.TableUpdater;

/**
 * Created by Eefret on 5/4/2014.
 */
public class DatabaseProvider extends ProviGenProvider {
    @Override
    public SQLiteOpenHelper openHelper(Context context) {
        return new SQLiteOpenHelper(getContext(),"MissRepDomDatabase",null,1) {
            @Override
            public void onCreate(SQLiteDatabase database) {
                new TableBuilder(ModelsContract.class).createTable(database);
                new TableBuilder(ModelsImagesContract.class).createTable(database);
                new TableBuilder(UserPreferencesContract.class).createTable(database);
                //Populate Database here
                //UserPreferences
                insertPreferences(database);
                //Models
                insertModels(database);


                Log.d("DatabaseProvider","database populated");
            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
                new TableUpdater().addMissingColumns(sqLiteDatabase,ModelsContract.class);
                new TableUpdater().addMissingColumns(sqLiteDatabase,ModelsImagesContract.class);
                new TableUpdater().addMissingColumns(sqLiteDatabase,UserPreferencesContract.class);
            }
        };

    }

    @Override
    public Class[] contractClasses() {
        return new Class[]{ModelsContract.class, ModelsImagesContract.class,UserPreferencesContract.class};
    }

    public void insertPreferences(SQLiteDatabase database){
        ContentValues cv = new ContentValues();
        cv.put(UserPreferencesContract.HAS_VOTED,0);
        cv.put(UserPreferencesContract.MODEL_VOTED,0);
        database.insert("user_preferences",null,cv);
    }

    public void insertModels(SQLiteDatabase database){
        ContentValues cv = new ContentValues();

        //Amelia vega
        cv.put(ModelsContract.MODEL_NUMBER,0);
        cv.put(ModelsContract.MODEL_NAME,"Amelia Vega");
        cv.put(ModelsContract.MODEL_AGE,29);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-90");
        cv.put(ModelsContract.MODEL_PROVINCE,"Santiago de los Caballeros");
        cv.put(ModelsContract.MODEL_SIZE,"6\'1\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Larimar Fiallo
        cv.put(ModelsContract.MODEL_NUMBER,1);
        cv.put(ModelsContract.MODEL_NAME,"Larimar Fiallo");
        cv.put(ModelsContract.MODEL_AGE,30);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-90");
        cv.put(ModelsContract.MODEL_PROVINCE,"La Vega");
        cv.put(ModelsContract.MODEL_SIZE,"6\'1\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Renata Sone
        cv.put(ModelsContract.MODEL_NUMBER,2);
        cv.put(ModelsContract.MODEL_NAME,"Renata Sone");
        cv.put(ModelsContract.MODEL_AGE,31);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-90");
        cv.put(ModelsContract.MODEL_PROVINCE,"Distrito Nacional");
        cv.put(ModelsContract.MODEL_SIZE,"6\'1\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Mia Taveras
        cv.put(ModelsContract.MODEL_NUMBER,3);
        cv.put(ModelsContract.MODEL_NAME,"Mia Taveras");
        cv.put(ModelsContract.MODEL_AGE,27);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-90");
        cv.put(ModelsContract.MODEL_PROVINCE,"Santiago de los Caballeros");
        cv.put(ModelsContract.MODEL_SIZE,"6\'1\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Massiel Taveras
        cv.put(ModelsContract.MODEL_NUMBER,4);
        cv.put(ModelsContract.MODEL_NAME,"Massiel Taveras");
        cv.put(ModelsContract.MODEL_AGE,29);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-90");
        cv.put(ModelsContract.MODEL_PROVINCE,"Santiago de los Caballeros");
        cv.put(ModelsContract.MODEL_SIZE,"5\'8\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Marianne Cruz
        cv.put(ModelsContract.MODEL_NUMBER,5);
        cv.put(ModelsContract.MODEL_NAME,"Marianne Cruz");
        cv.put(ModelsContract.MODEL_AGE,29);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-90");
        cv.put(ModelsContract.MODEL_PROVINCE,"Hermanas Mirabal");
        cv.put(ModelsContract.MODEL_SIZE,"6\'1\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Ada de la Cruz
        cv.put(ModelsContract.MODEL_NUMBER,6);
        cv.put(ModelsContract.MODEL_NAME,"Ada de la Cruz");
        cv.put(ModelsContract.MODEL_AGE,28);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-90");
        cv.put(ModelsContract.MODEL_PROVINCE,"San Jose de Ocoa");
        cv.put(ModelsContract.MODEL_SIZE,"6\'1\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Eva Arias
        cv.put(ModelsContract.MODEL_NUMBER,7);
        cv.put(ModelsContract.MODEL_NAME,"Eva Arias");
        cv.put(ModelsContract.MODEL_AGE,29);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-93");
        cv.put(ModelsContract.MODEL_PROVINCE,"Espaillat");
        cv.put(ModelsContract.MODEL_SIZE,"5\'11\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Dalia Fernandez
        cv.put(ModelsContract.MODEL_NUMBER,8);
        cv.put(ModelsContract.MODEL_NAME,"Dalia Fernandez");
        cv.put(ModelsContract.MODEL_AGE,24);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-90");
        cv.put(ModelsContract.MODEL_PROVINCE,"Santiago de los Caballeros");
        cv.put(ModelsContract.MODEL_SIZE,"5\'9\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Dulcita Lieggi
        cv.put(ModelsContract.MODEL_NUMBER,9);
        cv.put(ModelsContract.MODEL_NAME,"Dulcita Lieggi");
        cv.put(ModelsContract.MODEL_AGE,24);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-90");
        cv.put(ModelsContract.MODEL_PROVINCE,"Distrito Nacional");
        cv.put(ModelsContract.MODEL_SIZE,"5\'9\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();

        //Yaritza Reyes
        cv.put(ModelsContract.MODEL_NUMBER,10);
        cv.put(ModelsContract.MODEL_NAME,"Yaritza Reyes");
        cv.put(ModelsContract.MODEL_AGE,20);
        cv.put(ModelsContract.MODEL_MEASURES,"90-60-93");
        cv.put(ModelsContract.MODEL_PROVINCE,"Elias Piña");
        cv.put(ModelsContract.MODEL_SIZE,"5\'9\"");
        cv.put(ModelsContract.MODEL_VOTES,1235546);
        database.insert("models",null,cv);
        cv.clear();


    }

}
