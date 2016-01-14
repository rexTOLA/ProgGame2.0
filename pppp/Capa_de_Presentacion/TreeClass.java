package Capa_de_Presentacion;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeClass extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTree tree;
	 private JLabel selectedLabel;
	 
	public TreeClass()
    {
		
		//create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Nivel Deslizar");
      //create the child nodes
        DefaultMutableTreeNode EJ_Deslizar = new DefaultMutableTreeNode("EJ_Deslizar");
        DefaultMutableTreeNode Hielo = new DefaultMutableTreeNode("Hielo");
        DefaultMutableTreeNode Hielo2 = new DefaultMutableTreeNode("Hielo2");
        DefaultMutableTreeNode ObjetoJuego = new DefaultMutableTreeNode("ObjetoJuego");
        DefaultMutableTreeNode Pared = new DefaultMutableTreeNode("Pared");
        DefaultMutableTreeNode Personaje = new DefaultMutableTreeNode("Personaje");
        DefaultMutableTreeNode Salida = new DefaultMutableTreeNode("Salida");
        DefaultMutableTreeNode Tile = new DefaultMutableTreeNode("Tile");
        
 
        //add the child nodes to the root node
        root.add(EJ_Deslizar);
        root.add(Hielo);
        root.add(Hielo2);
        root.add(ObjetoJuego);
        root.add(Pared);
        root.add(Personaje);
        root.add(Salida);
        root.add(Tile);
               
         
        //create the tree by passing in the root node
        tree = new JTree(root);
       

        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);
        add(new JScrollPane(tree));
         
        selectedLabel = new JLabel();
        add(selectedLabel, BorderLayout.SOUTH);
 
        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                selectedLabel.setText(selectedNode.getUserObject().toString());
                
            }
        });
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.setSize(200, 200);
        this.setVisible(true);
    }
			
    
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TreeClass();
            }
        });
	}
}
