package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {

    private static String TAG = "JsonUtils";

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        // Getting string and making JSON object out of it
        JSONObject jsonObject = new JSONObject(json);
        // Log.i(TAG, "parseSandwichJson: json object: " + jsonObject.toString());

        /*
        Getting all the values from JSON received
        */

        // Getting mainName
        String mainName = jsonObject.getJSONObject("name").getString("mainName");
        //Log.i(TAG, "parseSandwichJson: mainName is " + mainName);

        // Getting alsoKnownAs list
        JSONArray alsoKnownAsJsonArray = jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs");
        ArrayList<String> alsoKnownAs = new ArrayList<>();
        if (alsoKnownAsJsonArray != null) {
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJsonArray.getString(i).toString());
            }
        }

        // Getiing placeOfOrigin
        String placeOfOrigin = jsonObject.getString("placeOfOrigin");

        // Getting description
        String description = jsonObject.getString("description");

        // Getting image
        String image = jsonObject.getString("image");

        // Getting ingredients list
        JSONArray ingredientsJsonArray = jsonObject.getJSONArray("ingredients");
        ArrayList<String> ingredients = new ArrayList<>();
        if (ingredientsJsonArray != null) {
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredients.add(ingredientsJsonArray.get(i).toString());
            }
        }

        // Create a new Sandwich object and setting all the fields
        Sandwich sandwich = new Sandwich();
        sandwich.setMainName(mainName);
        sandwich.setAlsoKnownAs(alsoKnownAs);
        sandwich.setPlaceOfOrigin(placeOfOrigin);
        sandwich.setDescription(description);
        sandwich.setImage(image);
        sandwich.setIngredients(ingredients);

        return sandwich;
    }
}
