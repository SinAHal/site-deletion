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
   *
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
    * Receives current tableName. Finds dependency for this table.
    * @return A collection (CURSOR) of Foreign + Primary table names, Foreign + Primary key columns
    */
  def findDependencies() = {}

  /** *
    * Helper function for deleteDependencies.
    * Any other constraints on primary/foreign tables that need to be disabled (dropped) before a dependency is removed
    * should be handled here.
    * Receives collection containing foreign table name for dependency deletion, name of table that has constraint and
    * name of the constraint
    * @return
    */
  def disableConstraints() = {}

  /** *
    * Helper function for deleteDependencies.
    * Any constraints dropped as part of disableConstraints should be added back here. This restores integrity of DB.
    * Receives foreign table name, constraint table name and name of constraint
    * @return
    */
  def restoreConstraints() = {}

  /** *
    * Delete any data leftover for the current site that is being deleted. This handles anything that couldn't be
    * removed during the main process. Example: HTMLInjectionPoint and T_Sites
    */
  def siteCleanup() = {}
}
