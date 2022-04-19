package com.example.xpgainer;

import java.io.Serializable;
import java.util.ArrayList;

public class TasksHelper implements Serializable {

        private String tasks;
        private boolean active;


        public TasksHelper(String tasks)  {
            this.tasks= tasks;

        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }



}

