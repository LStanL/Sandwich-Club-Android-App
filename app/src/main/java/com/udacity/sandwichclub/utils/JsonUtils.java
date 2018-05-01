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
        String mainName = jsonObject.optJSONObject("name").optString("mainName", "N/A");
        //Log.i(TAG, "parseSandwichJson: mainName is " + mainName);

        // Getting alsoKnownAs list
        JSONArray alsoKnownAsJsonArray = jsonObject.optJSONObject("name").optJSONArray("alsoKnownAs");
        ArrayList<String> alsoKnownAs = new ArrayList<>();
        if (alsoKnownAsJsonArray != null) {
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJsonArray.optString(i, "N/A").toString());
            }
        }

        // Getting placeOfOrigin
        String placeOfOrigin = jsonObject.optString("placeOfOrigin", "N/A");

        // Getting description
        String description = jsonObject.optString("description", "N/A");

        // Getting image
        String image = jsonObject.optString("image", "N/A");

        // Getting ingredients list
        JSONArray ingredientsJsonArray = jsonObject.optJSONArray("ingredients");
        ArrayList<String> ingredients = new ArrayList<>();
        if (ingredientsJsonArray != null) {
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredients.add(ingredientsJsonArray.optString(i, "N/A").toString());
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
