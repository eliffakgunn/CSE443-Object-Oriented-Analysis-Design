package part3;

/**
 * Driver class for part3
 */
public class Driver {
     public static void main(String[] args) {
         Invoker invoker= new Invoker();
         Select select = new Select();
         Update update = new Update();
         Alter alter = new Alter();

         select.setName("FLOWER");
         update.setName("FLOWER");
         alter.setName("FLOWER");

         //create operations
         SelectCommand selectCommand = new SelectCommand(select);
         UpdateCommand updateCommand = new UpdateCommand(update);
         AlterCommand alterCommand = new AlterCommand(alter);

         //add operations to invoker
         invoker.setCommand(0, selectCommand);
         invoker.setCommand(1, updateCommand);
         invoker.setCommand(2, alterCommand);

         //TRANSACTION
         try{
             invoker.runOperation(0);
             invoker.runOperation(1);
             invoker.runOperation(2);
             System.out.println("Transaction completed successfully.");
         } catch (Exception e) {
             System.err.println("Transaction failed.");
             invoker.rollback();
         }
     }
}
