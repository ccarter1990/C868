package com.example.C868.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.C868.Adapters.PurchasedPartsAdapter;
import com.example.C868.Database.Repository;
import com.example.C868.Entity.PurchasedComponents;
import com.example.c868.R;

import java.util.List;

public class PurchasedComponentList extends AppCompatActivity {
    static RecyclerView recyclerView;
    static PurchasedPartsAdapter adapter;
    static List<PurchasedComponents> purchasedComponentsList;
    static Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchased_components_list);

        recyclerView = findViewById(R.id.recyclerViewPurchasedParts);
        repository = new Repository(getApplication());

        purchasedComponentsList = repository.getmAllPurchasedComponents();

        adapter = new PurchasedPartsAdapter(this);
        recyclerView.setAdapter(adapter);

        //change 1st parameter of method setPartsList from List<parts> to List<PurchasedComponents>
        adapter.setPartsList(purchasedComponentsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    protected void onResume() {
        super.onResume();
        PurchasedPartsAdapter.clickEnabled = true;
    }
}