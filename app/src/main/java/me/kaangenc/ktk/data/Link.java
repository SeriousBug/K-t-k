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

package me.kaangenc.ktk.data;


import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.Required;


public class Link extends RealmObject {
    @Required private String text = "";

    @LinkingObjects("links")
    private final RealmResults<GameObject> linkedObjects = null;

    public Link() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RealmResults<GameObject> getLinkedObjects() {
        return linkedObjects;
    }
}
