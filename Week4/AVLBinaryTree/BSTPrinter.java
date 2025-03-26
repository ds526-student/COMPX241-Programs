import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import HashTable.Node;

public class BSTPrinter { // Changed from package-private to public
   BSTPrinter() {
   }

   public static void printNode(Node var0) {
      int var1 = maxLevel(var0);
      printNodeInternal(Collections.singletonList(var0), 1, var1);
   }

   private static void printNodeInternal(List<Node> var0, int var1, int var2) {
      if (!var0.isEmpty() && !isAllElementsNull(var0)) {
         int var3 = var2 - var1;
         int var4 = (int)Math.pow(2.0, (double)Math.max(var3 - 1, 0));
         int var5 = (int)Math.pow(2.0, (double)var3) - 1;
         int var6 = (int)Math.pow(2.0, (double)(var3 + 1)) - 1;
         printWhitespaces(var5);
         ArrayList var7 = new ArrayList();

         for(Iterator var8 = var0.iterator(); var8.hasNext(); printWhitespaces(var6)) {
            Node var9 = (Node)var8.next();
            if (var9 != null) {
               System.out.print(var9.value);
               var7.add(var9.left);
               var7.add(var9.right);
            } else {
               var7.add((Object)null);
               var7.add((Object)null);
               System.out.print(" ");
            }
         }

         System.out.println("");

         for(int var10 = 1; var10 <= var4; ++var10) {
            for(int var11 = 0; var11 < var0.size(); ++var11) {
               printWhitespaces(var5 - var10);
               if (var0.get(var11) == null) {
                  printWhitespaces(var4 + var4 + var10 + 1);
               } else {
                  if (((Node)var0.get(var11)).left != null) {
                     System.out.print("/");
                  } else {
                     printWhitespaces(1);
                  }

                  printWhitespaces(var10 + var10 - 1);
                  if (((Node)var0.get(var11)).right != null) {
                     System.out.print("\\");
                  } else {
                     printWhitespaces(1);
                  }

                  printWhitespaces(var4 + var4 - var10);
               }
            }

            System.out.println("");
         }

         printNodeInternal(var7, var1 + 1, var2);
      }
   }

   private static void printWhitespaces(int var0) {
      for(int var1 = 0; var1 < var0; ++var1) {
         System.out.print(" ");
      }

   }

   private static int maxLevel(Node var0) {
      return var0 == null ? 0 : Math.max(maxLevel(var0.left), maxLevel(var0.right)) + 1;
   }

   private static boolean isAllElementsNull(List<Node> var0) {
      Iterator var1 = var0.iterator();

      Node var2;
      do {
         if (!var1.hasNext()) {
            return true;
         }

         var2 = (Node)var1.next();
      } while(var2 == null);

      return false;
   }
}
