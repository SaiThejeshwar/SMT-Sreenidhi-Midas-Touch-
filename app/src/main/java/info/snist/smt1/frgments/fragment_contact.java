package info.snist.smt1.frgments;

/**
 * Created by sai on 07-01-2016.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import info.snist.smt1.R;


public class fragment_contact extends Fragment {

    public fragment_contact(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout_contact, container, false);
        ExpandableListView elv = (ExpandableListView) rootView.findViewById(R.id.list);
        elv.setAdapter(new SavedTabsListAdapter());
        return rootView;
    }
    public class SavedTabsListAdapter extends BaseExpandableListAdapter {

        private String[] groups = {"\t\t\t\tChief Engineer","\t\t\t\tCo-Engineer(Treasurer)",
                "\t\t\t\tCo-Engineer (Counter Executive)", "\t\t\t\tCo-Engineer(Counter Executive)",
                "\t\t\t\tCo-Engineer(Developer)"/*"\t\t\t\tEngineer(Arts Club)"
                ,"\t\t\t\tTreasurer","\t\t\t\tSports Head","\t\t\t\tSports Head"
                ,"\t\t\t\tMarketing\n\t\t\t\tExecutive(Corporate)","\t\t\t\tMarketing\n\t\t\t\tExecutive(Corporate)",
                "\t\t\t\tMarketing\n\t\t\t\tExecutive(Stalls)",
                "\t\t\t\tTechnical Head","\t\t\t\tDocumentation","\t\t\t\tDesigning",
                "\t\t\t\tOff-Campus publicity","\t\t\t\tOnline-publicity","\t\t\t\tOn-Campus publicity",
                "\t\t\t\tCult Night",
                "\t\t\t\tHR","\t\t\t\tHospitality",*/
        };

        private String[][] children = {
                { "\n\t\tSk.Jani Basha \t 9652156877\n" },
                { "\n\t\tS.Hemanth   \t 8801154880\n" },
                { "\n\t\tN.Rakesh \t 8985898826\n" },
                { "\n\t\tP.Praveen \t\t9950361487\n" },
                { "\n\t\tS.Sai Thejeshwar \t\t\t\t8686962216\n" }
                /*{ "\n\t\tTarun Angala \t9989930929\n"},
                { "\n\t\tAnupama V \t\t8977856126\n"},
                { "\n\t\t N.Anurag \t\t9985143270\n" },
                {"\n\t\tAmith Gangishetty\t\t8121409975\n"},
                {"\n\t\tMahitha Sudhakar\t\t9133576408\n"},
                {"\n\t\tPratyusha Velamakanni\t\t9701430335\n"},
                {"\n\t\tSai Santosh Reddy \t\t9133576406\n"},
                {"\n\t\tSachin\t\t9703592382\n"},
                {"\n\t\tPrasheela somaraju\t\t9502488799\n"},
                {"\n\t\tAshwini Kumar\t\t7680919895\n"},
                {"\n\t\tSumanth\t\t9951147325\n"},
                {"\n\t\tKavya margam\t\t8019384165\n"},
                {"\n\t\tAnurag Sharma\t\t8801735118\n"},
                {"\n\t\tHarsha Sai\t\t9010406808\n"},
                {"\n\t\tShivam V\t\t9849370087\n"},
                {"\n\t\tBhavani Pagolu\t\t9441349374\n"}
*/
        };


        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            float k=25;
            TextView textView = new TextView(fragment_contact.this.getActivity());
            textView.setText(getGroup(i).toString());
            textView.setTextSize(k);
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            float k=20;
            TextView textView = new TextView(fragment_contact.this.getActivity());
            textView.setText(getChild(i, i1).toString());
            textView.setTextSize(k);
            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }

}

