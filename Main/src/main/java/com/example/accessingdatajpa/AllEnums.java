package com.example.accessingdatajpa;


public class AllEnums {

    public enum Etat{
        ETAT_OK("OK"),
        ETAT_HS("HS");

        private final String text;

        /**
         * @param text
         */
        Etat(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    public enum Sexe{
        HOMME,
        FEMME
    }

    public enum Classification{
        vMoins,
        vPlus,
        vNul
    }

//    public enum TempJournee{
//        MATIN,
//        JOURNEE,
//        SOIREE,
//        NUIT
//    }

}
