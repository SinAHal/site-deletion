import sun.invoke.empty.Empty

/**
 * Created by Sinan on 08/12/2014.
 */
class SiteDeletion {

  // Name of current site that is being deleted
  var currentSite : String = ""

  // Method for managing deletion process:
  // 1. Iterate through sites
  // 2. Call methods
  // 3. Log progress

  /** *
    * Drops all tables that contain the site's name in the table name
    * @return
    */
  def dropTablesForSite() = {}

  /**
   * Delete rows from all tables that have id of site to delete.
   * Iterate through each table
   * @return
   */
  def deleteRowsForSite() = {}

  /**
   * Helper function for deleteRowsForSite
   * Finds all tables and site-id columns of site we need to delete.
   * @return A collection (CURSOR) of tableNames and siteId columns
   */
  def findDataToDelete() = {}

  /** *
    * Helper function for deleteRowsForSite
    * Receives: Current tableName and siteId column to delete
    * Prints out the amount of rows that will be deleted for this table (if siteId == x)
    * @return
    */
  def printRowsToDelete() = {}

  /** *
    * Helper function for deleteRowsForSite
    * Iterate through each dependency and delete foreign key rows
    * @return
    */
  def deleteDependencies() = {}

  /** *
    * Helper function for deleteDependencies
    * Receives current tableName and siteId column to delete
    * @return
    */
  def findDependencies() = {}
}
