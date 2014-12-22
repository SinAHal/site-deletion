import java.sql.{Array => SqlArray, _}
;

/**
 * Created by Sinan on 18/12/2014.
 */

object JDBCLib {

  // Setup DB Config
  val CONNECT_TO = "jdbc:mysql://localhost:3306/test?user=root&password=chi11ib00m"
  val conn = retrieveConnection()


  def retrieveConnection() : Connection = {
    // Load the driver
    classOf[com.mysql.jdbc.Driver]

    // Setup and return the connection
    DriverManager.getConnection(CONNECT_TO)
  }

  // Var-args on queries?
  // Sort out adding where, order by and other stuff.

  @throws[SQLException]
  def selectQuery(query : String) : ResultSet = {
    // Configure to be Read Only
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    // Execute Query
    // Returned ResultSet is a cursor (NOT A DB CURSOR) on the results of the executed where query
    statement.executeQuery(query)
  }

  /** *
    * This method will iterate through the results of a select query and perform an operation for each result.
    * Can also restrict which columns to perform operation on
    * @param rs : ResultSet to perform operation
    * @param process: Operation performed on each result
    * @param columnNames : Name of specific columns operation is restricted to
    */
  def processResults(rs : ResultSet, process: (String) => Unit, columnNames : Array[String] = Array.empty[String]): Unit = columnNames match {
    case Array() => { // Output all columns
      // ResultSetMetaData: contains useful info about columns of a table
      val rsmd : ResultSetMetaData = rs.getMetaData
      val columnCount = rsmd.getColumnCount

      while (rs.next) {
        for (i <- 1 until columnCount+1) {
          process(rs.getString(i))
        }
      }
    }
    case _ => { // Process only columns specified in parameter
      // Iterate Over ResultSet
      // next makes rs move to the next values in cursor
      // true returned if there is another row, false returned if there isn't
      while (rs.next) {
        // getString is case insensitive -> getString(columnName)
        for(column <- columnNames)
          process(rs.getString(column))
      }
    }
  }

  /**
   *
   * @param query : A delete query
   */
  @throws[SQLException]
  def updateQuery(query : String): Unit = {
    // create database connection
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)

    // execute update query
    val prep = conn.prepareStatement(query)
    val n = prep.executeUpdate
    println(n + " row(s) affected")
  }

}
