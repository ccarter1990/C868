package com.example.C868.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.C868.Database.Repository;
import com.example.C868.Entity.AssemblyParts;
import com.example.C868.Entity.PurchasedComponents;
import com.example.c868.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PurchasedComponentDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText purchasedComponentName;
    EditText purchasedComponentDescription;
    EditText purchasedComponentPrice;
    EditText purchasedComponentQuantity;

    EditText purchasedComponentLocation;
    EditText purchasedComponentVendor;
    EditText purchasedComponentLeadTime;

    Spinner assemblyIDSpinner;

    Repository repository = new Repository(getApplication());

    List<AssemblyParts> assemblyPartsList = repository.getmAllAssemblyParts();
    ArrayList<AssemblyParts> assemblyPartsArrayList = new ArrayList<>();

    String name;
    String description;
    String price;
    String quantity;
    String location;
    String vendor;
    String leadTime;

    int assemblyID;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchased_components_details);

        //Get purchased component part name from clicked item in list on the PurchasedComponentList.java screen
        purchasedComponentName = findViewById(R.id.editTextViewPurchasedComponentName);
        name = getIntent().getStringExtra("partName");
        purchasedComponentName.setText(name);

        //Get purchased component part description from clicked item in list on the PurchasedComponentList.java screen
        purchasedComponentDescription = findViewById(R.id.editTextViewPurchasedComponentQuantity);
        description = getIntent().getStringExtra("partDescription");
        purchasedComponentDescription.setText(description);

        //Get purchased component part price from clicked item in list on the PurchasedComponentList.java screen
        purchasedComponentPrice = findViewById(R.id.editTextViewPurchasedComponentQuantity);
        price = getIntent().getStringExtra("partPrice");
        purchasedComponentPrice.setText(price);

        //Get purchased component part quantity from clicked item in list on the PurchasedComponentList.java screen
        purchasedComponentQuantity = findViewById(R.id.editTextViewPurchasedComponentQuantity);
        quantity = getIntent().getStringExtra("partQuantity");
        purchasedComponentQuantity.setText(quantity);

        //Get purchased component part location from clicked item in list on the PurchasedComponentList.java screen
        purchasedComponentLocation = findViewById(R.id.editTextViewPurchasedComponentLocation);
        location = getIntent().getStringExtra("partLocation");
        purchasedComponentLocation.setText(location);

        //Get purchased component part vendor from clicked item in list on the PurchasedComponentList.java screen
        purchasedComponentVendor = findViewById(R.id.editTextViewPurchasedComponentLeadTime);
        vendor = getIntent().getStringExtra("partVendor");
        purchasedComponentVendor.setText(vendor);

        //Get purchased component part lead time from clicked item in list on the PurchasedComponentList.java screen
        purchasedComponentLeadTime = findViewById(R.id.editTextViewPurchasedComponentLeadTime);
        leadTime = String.valueOf(getIntent().getIntExtra("partLeadTime", 0));
        purchasedComponentLeadTime.setText(leadTime);

        //Get purchased component part assembly ID from clicked item in list on the PurchasedComponentList.java screen
        assemblyIDSpinner = findViewById(R.id.purchasedComponentAssemblyIDSpinner);
        assemblyID = getIntent().getIntExtra("partAssemblyID", 0);
        assemblyIDSpinner.setSelection(assemblyID);

        //Set spinner to display assembly ID
        assemblyPartsArrayList.addAll(assemblyPartsList);
        final ArrayAdapter<AssemblyParts> purchasedComponentsArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, assemblyPartsArrayList);
        purchasedComponentsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assemblyIDSpinner.setAdapter(purchasedComponentsArrayAdapter);

        assemblyIDSpinner.setOnItemSelectedListener(this);
        assemblyIDSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                assemblyID = assemblyPartsArrayList.get(position).getAssemblyID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}