package edu.mit.viral.shen.db;
import edu.mit.viral.shen.R;

import edu.mit.viral.shen.gamelogic.DroidChessController;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String TAG = "DatabaseHelper";

	public static final int DATABASE_VERSION = 8;

	private Context mContext;

	DatabaseHelper(Context context) {
		super(context, SudokuDatabase.DATABASE_NAME, null, DATABASE_VERSION);
		this.mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + SudokuDatabase.SUDOKU_TABLE_NAME + " ("
				+ SudokuColumns._ID + " INTEGER PRIMARY KEY,"
				+ SudokuColumns.FOLDER_ID + " INTEGER,"
				+ SudokuColumns.CREATED + " INTEGER,"
				+ SudokuColumns.STATE + " INTEGER,"
				+ SudokuColumns.TIME + " INTEGER,"
				+ SudokuColumns.LAST_PLAYED + " INTEGER,"
				+ SudokuColumns.DATA + " Text,"
				+ SudokuColumns.PUZZLE_NOTE + " Text"
				+ ");");

		db.execSQL("CREATE TABLE " + SudokuDatabase.FOLDER_TABLE_NAME + " ("
				+ FolderColumns._ID + " INTEGER PRIMARY KEY,"
				+ SudokuColumns.CREATED + " INTEGER,"
				+ FolderColumns.NAME + " TEXT"
				+ ");");

		insertFolder(db, 1, mContext.getString(R.string.difficulty_easy));
		insertSudoku(db, 1, 1, "Easy1",  "4D3/4p3/2r5/6b1/8/7b/5p2/7K w KQkq - 1 1");
		insertSudoku(db, 1, 2, "Easy2", "2Dr4/8/3n4/4b3/8/8/2K5/8 w KQkq - 1 1");
		insertSudoku(db, 1, 3, "Easy3", "2D5/3b4/4p3/3n4/4r3/8/8/3K4 w KQkq - 0 1");
		insertSudoku(db, 1, 4, "Easy4", "4D3/4p3/5n2/4r3/3r4/2b5/8/3K4 w KQkq - 0 1");
		insertSudoku(db, 1, 5, "Easy5", "3rD3/6b1/8/8/8/8/8/4K3 w KQkq - 0 1");
		insertSudoku(db, 1, 6, "Easy6", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 7, "Easy7", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 8, "Easy8", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 9, "Easy9", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 10, "Easy10", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 11, "Easy11", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 12, "Easy12", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 13, "Easy13", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 14, "Easy14", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 15, "Easy15", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 16, "Easy16", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 17, "Easy17", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 18, "Easy18", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 19, "Easy19", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 20, "Easy20", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 21, "Easy21", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 22, "Easy22", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 23, "Easy23", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 24, "Easy24", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 25, "Easy25", "DK6/8/1p3r2/8/8/2b2b2/8/8 w KQkq - 1 1");
		insertSudoku(db, 1, 26, "Easy26", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 27, "Easy27", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 28, "Easy28", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 29, "Easy29", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 1, 30, "Easy30", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertFolder(db, 2, mContext.getString(R.string.difficulty_medium));
		insertSudoku(db, 2, 31, "Medium1", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 32, "Medium2", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 33, "Medium3", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 34, "Medium4", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 35, "Medium5", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 36, "Medium6", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 37, "Medium7", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 38, "Medium8", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 39, "Medium9", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 40, "Medium10", "8/8/8/8/8/8/8/8 w KQkq - 0 1");
		insertSudoku(db, 2, 41, "Medium11", "200006143004000600607008029100800200003090800005003001830500902006000400942600005");
		insertSudoku(db, 2, 42, "Medium12", "504002030900073008670000020000030780005709200047060000050000014100450009060300502");
		insertSudoku(db, 2, 43, "Medium13", "580000637000000000603540000090104705010709040807205090000026304000000000468000072");
		insertSudoku(db, 2, 44, "Medium14", "000010000900003408670500021000130780015000240047065000750006014102400009000090000");
		insertSudoku(db, 2, 45, "Medium15", "780300050956000000002065001003400570600000003025008100200590800000000417030004025");
		insertSudoku(db, 2, 46, "Medium16", "200367500500800060300450700090530400080000070003074050001026005030005007002783001");
		insertSudoku(db, 2, 47, "Medium17", "801056200000002381900003000350470000008000100000068037000600002687100000004530806");
		insertSudoku(db, 2, 48, "Medium18", "300004005841753060000010000003000087098107540750000100000070000030281796200300008");
		insertSudoku(db, 2, 49, "Medium19", "000064810040050062009010300003040607008107500704030100006070200430080090017390000");
		insertSudoku(db, 2, 50, "Medium20", "000040320000357080000600400357006040600705003080900675008009000090581000064070000");
		insertSudoku(db, 2, 51, "Medium21", "905040026026050900030600050350000009009020800100000075010009030003080760560070108");
		insertSudoku(db, 2, 52, "Medium22", "010403060030017400200000300070080004092354780500070030003000005008530040050906020");
		insertSudoku(db, 2, 53, "Medium23", "605900100000100073071300005009010004046293510700040600200001730160002000008009401");
		insertSudoku(db, 2, 54, "Medium24", "049060002800210490100040000000035084008102300630470000000080001084051006700020950");
		insertSudoku(db, 2, 55, "Medium25", "067020300003700000920103000402035060300000002010240903000508039000009200008010750");
		insertSudoku(db, 2, 56, "Medium26", "050842001004000900800050040600400019007506800430009002080090006001000400500681090");
		insertSudoku(db, 2, 57, "Medium27", "000076189000002030009813000025000010083000590070000460000365200010700000536120000");
		insertSudoku(db, 2, 58, "Medium28", "080000030400368000350409700000003650003000900078100000004201076000856009060000020");
		insertSudoku(db, 2, 59, "Medium29", "000500748589000001700086900302010580000000000067050204004760002200000867876005000");
		insertSudoku(db, 2, 60, "Medium30", "021009008000004031740100025000007086058000170160800000910008052230900000800300410");
		insertFolder(db, 3, mContext.getString(R.string.difficulty_hard));
		insertSudoku(db, 3, 61, "Hard1", "600300100071620000805001000500870901009000600407069008000200807000086410008003002");
		insertSudoku(db, 3, 62, "Hard2", "906013008058000090030000010060800920003409100049006030090000080010000670400960301");
		insertSudoku(db, 3, 63, "Hard3", "300060250000500103005210486000380500030000040002045000413052700807004000056070004");
		insertSudoku(db, 3, 64, "Hard4", "060001907100007230080000406018002004070040090900100780607000040051600009809300020");
		insertSudoku(db, 3, 65, "Hard5", "600300208400185000000000450000070835030508020958010000069000000000631002304009006");
		insertSudoku(db, 3, 66, "Hard6", "400030090200001600760800001500318000032000510000592008900003045001700006040020003");
		insertSudoku(db, 3, 67, "Hard7", "004090170900070002007204000043000050798406213060000890000709400600040001085030700");
		insertSudoku(db, 3, 68, "Hard8", "680001003007004000000820000870009204040302080203400096000036000000500400700200065");
		insertSudoku(db, 3, 69, "Hard9", "000002000103400005200050401340005090807000304090300017605030009400008702000100000");
		insertSudoku(db, 3, 70, "Hard10", "050702003073480005000050400040000200027090350006000010005030000400068730700109060");
		insertSudoku(db, 3, 71, "Hard11", "500080020007502801002900040024000308000324000306000470090006700703208900060090005");
		insertSudoku(db, 3, 72, "Hard12", "108090000200308096090000400406009030010205060080600201001000040360904007000060305");
		insertSudoku(db, 3, 73, "Hard13", "010008570607050009052170000001003706070000040803700900000017260100020407024300090");
		insertSudoku(db, 3, 74, "Hard14", "020439800080000001003001520050092703000000000309740080071300900600000030008924010");
		insertSudoku(db, 3, 75, "Hard15", "000500201800006005005207080017960804000000000908074610080405300700600009504009000");
		insertSudoku(db, 3, 76, "Hard16", "920000000500870000038091000052930160090000030073064980000410250000053001000000073");
		insertSudoku(db, 3, 77, "Hard17", "590006010001254709000001400003715008100000004200648100002500000708463900050100047");
		insertSudoku(db, 3, 78, "Hard18", "309870004000005008870400000104580003000706000700034105000009081900300000400057206");
		insertSudoku(db, 3, 79, "Hard19", "800200000910300706000007002084000009095104860100000230500600000609003071000005008");
		insertSudoku(db, 3, 80, "Hard20", "005037001000050627600002530020070000001968200000010090013700008486090000700840100");
		insertSudoku(db, 3, 81, "Hard21", "090350700000800029000402008710000000463508297000000051300204000940005000008037040");
		insertSudoku(db, 3, 82, "Hard22", "000005904080090605006000030030701450008040700074206090060000300801060070309800000");
		insertSudoku(db, 3, 83, "Hard23", "030004087948700500060800009010586720000000000087312050800003070003007865570200090");
		insertSudoku(db, 3, 84, "Hard24", "300687015000030082050000300400300000601050709000004003008000020210040000970521004");
		insertSudoku(db, 3, 85, "Hard25", "702000004030702010400093008000827090007030800080956000300570009020309080600000503");
		insertSudoku(db, 3, 86, "Hard26", "300040057400853060025700000000000430800406001034000000000005690090624003160080002");
		insertSudoku(db, 3, 87, "Hard27", "000260050000005900000380046020094018004000500950810070380021000005700000040058000");
		insertSudoku(db, 3, 88, "Hard28", "062080504008050090700320001000740620000203000027065000200036007040070100803090240");
		insertSudoku(db, 3, 89, "Hard29", "002001000068000003000086090900002086804000102520800009080140000100000920000700500");
		insertSudoku(db, 3, 90, "Hard30", "000030065460950200000086004003070006004090100500010300200140000007065028630020000");        
		createIndexes(db);
	}

	private void insertFolder(SQLiteDatabase db, long folderID, String folderName) {
		long now = System.currentTimeMillis();
		db.execSQL("INSERT INTO " + SudokuDatabase.FOLDER_TABLE_NAME + " VALUES (" + folderID + ", " + now + ", '" + folderName + "');");
	}

	// TODO: sudokuName is not used
	private void insertSudoku(SQLiteDatabase db, long folderID, long sudokuID, String sudokuName, String data) {
		String sql = "INSERT INTO " + SudokuDatabase.SUDOKU_TABLE_NAME + " VALUES (" + sudokuID + ", " + folderID + ", 0, " + DroidChessController.GAME_STATE_NOT_STARTED + ", 0, null, '" + data + "', null);";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i(TAG, "Upgrading database from version " + oldVersion + " to "
				+ newVersion + ".");

		createIndexes(db);
	}

	private void createIndexes(SQLiteDatabase db) {
		db.execSQL("create index " + SudokuDatabase.SUDOKU_TABLE_NAME +
				"_idx1 on " +
				SudokuDatabase.SUDOKU_TABLE_NAME + " (" + SudokuColumns.FOLDER_ID + ");");
	}
}
