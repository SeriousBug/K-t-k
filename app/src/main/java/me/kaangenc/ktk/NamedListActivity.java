/*
 * Copyright 2017 Kaan Genç
 *
 * This file is part of Kütük.
 *
 * Kütük is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kütük is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Kütük.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.kaangenc.ktk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import io.realm.Realm;
import me.kaangenc.ktk.data.NamedRealmFactory;


abstract class NamedListActivity extends AppCompatActivity {
    protected Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.named_list);
        realm = Realm.getDefaultInstance();
        RecyclerView namedView = (RecyclerView) findViewById(R.id.named_list_view);
        namedView.setLayoutManager(new LinearLayoutManager(this));
        namedView.setAdapter(getViewAdapter());

        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.add_button);
        addButton.setImageDrawable(MaterialDrawableBuilder.with(this)
                .setIcon(MaterialDrawableBuilder.IconValue.PLUS)
                .setColorResource(R.color.text_light)
                .build()
        );
    }

    abstract protected RecyclerView.Adapter getViewAdapter();
    abstract protected NamedRealmFactory getRealmFactory();
    /**
     * @return The string that will be displayed as the title of the list.
     */
    abstract protected String getListTitle();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
        realm = null;
    }

    public void addNamed(View view) {
        CreateNamedDialog dialog = new CreateNamedDialog(
                getListTitle(),
                this,
                getRealmFactory()
        );
        dialog.show();
    }
}
