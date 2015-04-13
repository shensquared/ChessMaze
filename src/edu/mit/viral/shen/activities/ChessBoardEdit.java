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

package edu.mit.viral.shen.activities;

import edu.mit.viral.shen.ChessBoard;
import edu.mit.viral.shen.gamelogic.Move;
import edu.mit.viral.shen.gamelogic.Piece;
import edu.mit.viral.shen.gamelogic.Position;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;

/** Chess board widget suitable for edit mode. */
public class ChessBoardEdit extends ChessBoard {
    private final boolean landScape;

    public ChessBoardEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawSquareLabels = true;
        hinted=false;

        Configuration config = getResources().getConfiguration();
        landScape = (config.orientation == Configuration.ORIENTATION_LANDSCAPE);
    }

    private final static int gap = 4;

    @Override
    protected int getWidth(int sqSize) {
        return landScape ? sqSize * 10 + gap : sqSize * 8;
    }
    @Override
    protected int getHeight(int sqSize) {
        return landScape ? sqSize * 8 : sqSize * 10 + gap;
    }
    @Override
    protected int getSqSizeW(int width) {
        return landScape ? (width - gap) / 10 : width / 8;
    }
    @Override
    protected int getSqSizeH(int height) {
        return landScape ? height / 8 : (height - gap) / 10;
    }
    @Override
    protected int getMaxHeightPercentage() { return 85; }
    @Override
    protected int getMaxWidthPercentage() { return 75; }

    @Override
    protected void computeOrigin(int width, int height) {
        x0 = (width - getWidth(sqSize)) / 2;
        y0 = landScape ? 0 : (height - getHeight(sqSize)) / 2;
    }

    private final int extraPieces(int x, int y) {
        if (landScape) {
            if (x == 8) {
                switch (y) {
                case 0: return Piece.WKING;
                // case 1: return Piece.WQUEEN;
                // case 2: return Piece.WROOK;
                // case 3: return Piece.WBISHOP;
                // case 4: return Piece.WKNIGHT;
                // case 5: return Piece.WPAWN;
                //case 6: return Piece.EMPTY;//aug8
                }
            } else if (x == 9) {
                switch (y) {
                case 0: return Piece.BKING;
                case 1: return Piece.BQUEEN;
                case 2: return Piece.BROOK;
                case 3: return Piece.BBISHOP;
                case 4: return Piece.BKNIGHT;
                case 5: return Piece.BPAWN;
                case 6: return Piece.DEST;//aug8
                }
            }
        } else {
            if (y == -1) {
                switch (x) {
                case 0: return Piece.WKING;
                // case 1: return Piece.WQUEEN;
                // case 2: return Piece.WROOK;
                // case 3: return Piece.WBISHOP;
                // case 4: return Piece.WKNIGHT;
                // case 5: return Piece.WPAWN;
                }
            } else if (y == -2) {
                switch (x) {
                case 0: return Piece.BKING;
                case 1: return Piece.BQUEEN;
                case 2: return Piece.BROOK;
                case 3: return Piece.BBISHOP;
                case 4: return Piece.BKNIGHT;
                case 5: return Piece.BPAWN;
                case 6: return Piece.DEST;
                }
            }
        }
       return Piece.EMPTY;
    }

    @Override
    protected int getXFromSq(int sq) {
        if (sq >= 0) {
            return Position.getX(sq);
        } else {
            int p = -2 - sq;
            if (landScape) {
                return Piece.isWhite(p) ? 8 : 9;
            } else {
                switch (p) {
                case Piece.WKING:   case Piece.BKING:   return 0;
                case Piece.WQUEEN:  case Piece.BQUEEN:  return 1;
                case Piece.WROOK:   case Piece.BROOK:   return 2;
                case Piece.WBISHOP: case Piece.BBISHOP: return 3;
                case Piece.WKNIGHT: case Piece.BKNIGHT: return 4;
                case Piece.WPAWN:   case Piece.BPAWN:   return 5;
                case Piece.DEST: return 6;
                default: return 6;
                }
            }
        }
    }

    @Override
    protected int getYFromSq(int sq) {
        if (sq >= 0) {
            return Position.getY(sq);
        } else {
            int p = -2 - sq;
            if (landScape) {
                switch (p) {
                case Piece.WKING:   case Piece.BKING:   return 0;
                case Piece.WQUEEN:  case Piece.BQUEEN:  return 1;
                case Piece.WROOK:   case Piece.BROOK:   return 2;
                case Piece.WBISHOP: case Piece.BBISHOP: return 3;
                case Piece.WKNIGHT: case Piece.BKNIGHT: return 4;
                case Piece.WPAWN:   case Piece.BPAWN:   return 5;
                case Piece.DEST: return 6;
                default: return 6;
                }
            } else {
                return Piece.isWhite(p) ? -1 : -2;
            }
        }
    }

    @Override
    protected int getSquare(int x, int y) {
        if ((y >= 0) && (x < 8)) {
            return Position.getSquare(x, y);
        } else {
            int p = extraPieces(x, y);
            return -p - 2;
        }
    }

    @Override
    protected void drawExtraSquares(Canvas canvas) {
        int xMin = landScape ?  8 :  0;
        int xMax = landScape ? 10 :  8;
        int yMin = landScape ?  0 : -2;
        int yMax = landScape ?  8 :  0;
        for (int x = xMin; x < xMax; x++) {
            for (int y = yMin; y < yMax; y++) {
                final int xCrd = getXCrd(x);
                final int yCrd = getYCrd(y);
                Paint paint = Position.darkSquare(x, y) ? darkPaint : brightPaint;
                canvas.drawRect(xCrd, yCrd, xCrd+sqSize, yCrd+sqSize, paint);
                int p = extraPieces(x, y);
                drawPiece(canvas, xCrd, yCrd, p);
            }
        }
    }
    @Override
    protected void drawArrow(Canvas canvas) {
            float h = (float)(sqSize / 2.0);
            float d = (float)(sqSize / 8.0);
            double v = 35 * Math.PI / 180;
            double cosv = Math.cos(v);
            double sinv = Math.sin(v);
            double tanv = Math.tan(v);
            //int n = Math.min(moveMarkPaint.size(), moveHints.size());
            int n=1;
            for (int i = 0; i < n; i++) {
                int x = landScape ?   9:  6;
                int y = landScape ? 6:  -2;
                float x0 = landScape ? getXCrd(x) +2*h: getXCrd(x) +h;
                float y0 = landScape ? getYCrd(y) + h: getYCrd(y) + 2*h;
                float x1 = landScape ? getXCrd(8) + 2*h+d: getXCrd(6)+h;
                float y1 = landScape ? getYCrd(6) +h :  getYCrd(-1) + 2*h +d;

                float x2 = (float)(Math.hypot(x1 - x0, y1 - y0) + d);
                float y2 = 0;
                float x3 = (float)(x2 - h * cosv);
                float y3 = (float)(y2 - h * sinv);
                float x4 = (float)(x3 - d * sinv);
                float y4 = (float)(y3 + d * cosv);
                float x5 = (float)(x4 + (-d/2 - y4) / tanv);
                float y5 = (float)(-d / 2);
                float x6 = 0;
                float y6 = y5 / 2;
                Path path = new Path();
                path.moveTo(x2, y2);
                path.lineTo(x3, y3);
             // path.lineTo(x4, y4);
                path.lineTo(x5, y5);
                path.lineTo(x6, y6);
                path.lineTo(x6, -y6);
                path.lineTo(x5, -y5);
        // path.lineTo(x4, -y4);
                path.lineTo(x3, -y3);
                path.close();
                Matrix mtx = new Matrix();
                mtx.postRotate((float)(Math.atan2(y1 - y0, x1 - x0) * 180 / Math.PI));
                mtx.postTranslate(x0, y0);
                path.transform(mtx);
                Paint p = arrowPaint;
                // p.setStyle(Paint.Style.FILL);
                // p.setColor(230);
                canvas.drawPath(path, p);


            }
        }



    @Override
    public
    Move mousePressed(int sq) {
        // System.out.println(sq);
        if (sq == -1)
            return null;
        cursorVisible = false;
        if (selectedSquare != -1) {
           if (sq != selectedSquare) {
                Move m = new Move(selectedSquare, sq, Piece.EMPTY);
                setSelection(sq);
                return m;
            }
            setSelection(-1);
        } else {
            setSelection(sq);
        }
        return null;
    }

    @Override
    protected int minValidY() {
        return landScape ? 0 : -2;
    }
    @Override
    protected int maxValidX() {
        return landScape ? 9 : 7;
    }

    @Override
    protected int getXCrd(int x) {
        return x0 + sqSize * x + ((x >= 8) ? gap : 0);
    }

    @Override
    protected int getYCrd(int y) {
        return y0 + sqSize * (7 - y) + ((y < 0) ? gap : 0);
    }

    @Override
    protected int getXSq(int xCrd) {
        int x = (xCrd - x0) / sqSize;
        if (x < 8)
            return x;
        return (xCrd - x0 - gap) / sqSize;
    }

    @Override
    protected int getYSq(int yCrd) {
        int y = 7 - (yCrd - y0) / sqSize;
        if (y >= 0)
            return y;
        return 7 - (yCrd - y0 - gap) / sqSize;
    }

    /**
     * Compute the square corresponding to the coordinates of a mouse event.
     * @param evt Details about the mouse event.
     * @return The square corresponding to the mouse event, or -1 if outside board.
     */
    @Override
    public int eventToSquare(MotionEvent evt) {
        int sq = super.eventToSquare(evt);
        if (sq != -1)
            return sq;

        int xCrd = (int)(evt.getX());
        int yCrd = (int)(evt.getY());

        if (sqSize > 0) {
            int x = getXSq(xCrd);
            int y = getYSq(yCrd);
            if ( landScape && (x >= 0) && (x < 10) && (y >= 0) && (y < 8) ||
                !landScape && (x >= 0) && (x < 8) && (y >= -2) && (y < 0)) {
                int p = extraPieces(x, y);
                sq = -p - 2;
            }
        }
        return sq;
    }
}
