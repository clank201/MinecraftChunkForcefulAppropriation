package com.slabbababba.pluginTest;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Klanc on 17/03/2017.
 */
public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        int SSIZE = 7;
        int CHUNK_SIZE = 64;
        Integer[][][] mon= new Integer[64][64][64];
        for(int cx=0;cx<SSIZE;cx++){
            for(int cy=0;cy<SSIZE;cy++){
                for(int cz=0;cz<2;cz++){
                    try{
                        for(int i=0;i<64;i++){
                            for(int j=0;j<64;j++){
                                for(int k=0;k<64;k++){
                                    mon[i][j][k]=getServer().getWorld("world").getBlockAt(i+cx*CHUNK_SIZE,k+cz*CHUNK_SIZE,j+cy*CHUNK_SIZE).getType().getId();
                                }
                            }
                        }
                        PrintWriter writer = new PrintWriter("terrain."+cx+'.'+cy+'.'+cz, "UTF-8");
                        int current = (int)mon[0][0][0];
                        int num = 0;
                        for (int i = 0; i < CHUNK_SIZE; i++) {
                            for (int j = 0; j < CHUNK_SIZE; j++) {
                                for (int k = 0; k < CHUNK_SIZE; k++) {
                                    Integer block = (int)mon[k][j][i];
                                    if(block >20) block = 0;
                                    if (block != current || (i==CHUNK_SIZE-1 && j==CHUNK_SIZE-1 && k==CHUNK_SIZE-1)) {
                                        writer.print(current);
                                        writer.print(" ");
                                        writer.print(num);
                                        writer.print(" ");
                                        current = block;
                                        num = 1;
                                    }
                                    else {
                                        num++;
                                    }
                                }
                            }
                        }
                        writer.close();
                    } catch (IOException e) {
                        // do something
                    }
                }
            }
        }

    }
    @Override
    public void onDisable(){
        //Fired when the server enables the plugin
    }
}