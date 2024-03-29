/*
    DroidFish - An Android chess program.
    Copyright (C) 2011  Peter Österlund, peterosterlund2@gmail.com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package edu.mit.viral.shen.book;

import java.util.ArrayList;

import edu.mit.viral.shen.book.DroidBook.BookEntry;
import edu.mit.viral.shen.gamelogic.Position;


interface IOpeningBook {
    /** Return true if book is currently enabled. */
    boolean enabled();

    /** Set book options, including filename. */
    void setOptions(BookOptions options);

    /** Get all book entries for a position. */
    ArrayList<BookEntry> getBookEntries(Position pos);
}
