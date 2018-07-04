package reminder.daterangesearch.br.unb.cic.reminders.model.db;

/*** added by dManageReminder* modified by dDateRange
 */
public class DBConstants {
	public static String DROP_TABLE_STATEMENTS [] = {
		"DROP TABLE IF EXISTS REMINDER"
	};
	public static String CREATE_TABLE_STATEMENTS [] = {
		"CREATE TABLE REMINDER ( " + "PK INTEGER PRIMARY KEY AUTOINCREMENT, " +
		"TEXT VARCHAR(50) NOT NULL," + "DETAILS VARCHAR(50) NULL," + tableStatement()
		+ "DONE INTEGER NOT NULL);"
	};
	public static final String SELECT_REMINDERS = "SELECT * FROM REMINDER";
	public static String REMINDER_TABLE = "REMINDER";
	public static String REMINDER_PK_COLUMN = "PK";
	public static String REMINDER_TEXT_COLUMN = "TEXT";
	public static String REMINDER_DETAILS_COLUMN = "DETAILS";
	public static String REMINDER_DONE_COLUMN = "DONE";
	/*** added by dDateRange
	 */
	private static String tableStatement() {
		return "INITIAL_DATE CHAR(10) NOT NULL," + "INITIAL_HOUR CHAR(5) NULL," +
		"FINAL_DATE CHAR(10) NOT NULL," + "FINAL_HOUR CHAR(5) NULL,";
	}
	/*** added by dDateRange
	 */
	public static String REMINDER_INITIAL_DATE_COLUMN = "INITIAL_DATE";
	/*** added by dDateRange
	 */
	public static String REMINDER_INITIAL_HOUR_COLUMN = "INITIAL_HOUR";
	/*** added by dDateRange
	 */
	public static String REMINDER_FINAL_DATE_COLUMN = "FINAL_DATE";
	/*** added by dDateRange
	 */
	public static String REMINDER_FINAL_HOUR_COLUMN = "FINAL_HOUR";
}