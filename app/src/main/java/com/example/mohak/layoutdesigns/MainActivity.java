package com.example.mohak.layoutdesigns;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setTitle("Complex Recycler View");

        }
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        Adapter adapter = new Adapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }


    public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        Context c;
        private int i = 0;
        private int y = 0;
        private static final int ITEM = 1;
        private static final int HEADER = 0;
        private static final int ITEM2 = 2;
        private View v;


        public Adapter(Context c) {
            this.c = c;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(c);
            MyViewHolder viewholder = null;
            switch (viewType) {
                case HEADER:
                    v = inflater.inflate(R.layout.single_rec, null);
                    viewholder = new MyViewHolder(v, viewType);
                    break;
                case ITEM:
                    v = inflater.inflate(R.layout.single_rec_2, null);
                    viewholder = new MyViewHolder(v, viewType);
                    break;
                case ITEM2:
                    v = inflater.inflate(R.layout.single_rec_3, null);
                    viewholder = new MyViewHolder(v,viewType);
                    break;

            }
            return viewholder;

        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {

            if (holder.holderid == 0) {
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i++;
                        if (i % 2 == 0) {
                            holder.circleImageView.setVisibility(View.INVISIBLE);
                            holder.imageView.setAlpha(1.f);
                        } else {
                            holder.circleImageView.setVisibility(View.VISIBLE);
                            Animation animation = AnimationUtils.loadAnimation(c, R.anim.circular);
                            holder.circleImageView.startAnimation(animation);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    holder.imageView.setAlpha(0.7f);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }


                    }
                });
            } else if (holder.holderid == 1) {
                holder.cardView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        y++;
                        if (y % 2 == 0) {
                            holder.imageView2.setVisibility(View.INVISIBLE);
                            holder.imageView3.setVisibility(View.INVISIBLE);
                            holder.imageView5.findViewById(View.INVISIBLE);
                            holder.textView.setVisibility(View.INVISIBLE);
                            holder.imageView4.setAlpha(1.f);
                        } else {
                            holder.imageView2.setVisibility(View.VISIBLE);
                            holder.imageView5.setVisibility(View.VISIBLE);
                            Animation animation = AnimationUtils.loadAnimation(c, R.anim.img);
                            Animation animation2 = AnimationUtils.loadAnimation(c, R.anim.img2);
                            Animation animation3 = AnimationUtils.loadAnimation(c, R.anim.text);
                            holder.textView.startAnimation(animation3);
                            holder.imageView2.startAnimation(animation);
                            holder.imageView3.startAnimation(animation2);
                            animation3.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                    holder.imageView3.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {

                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                            animation2.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    holder.imageView4.setAlpha(0.7f);

                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {
                                }
                            });

                        }
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }

        @Override
        public int getItemViewType(int position) {

            if (position == 0) {
                return HEADER;
            } else if (position==1){
                return ITEM;
            }else
            {
                return ITEM2;
            }

        }


        public class MyViewHolder extends RecyclerView.ViewHolder
                //This class needs to be a sub class of the Adapter class

        {
            CircleImageView circleImageView;
            TextView textView;
            CardView cardView, cardView2;
            ImageView imageView, imageView2, imageView3, imageView4,imageView5;
            int holderid;


            public MyViewHolder(View itemView, int position) {
                super(itemView);
                if (position == HEADER) {
                    circleImageView = (CircleImageView) itemView.findViewById(R.id.circle);
                    cardView = (CardView) itemView.findViewById(R.id.card);
                    imageView = (ImageView) itemView.findViewById(R.id.image);
                    holderid = 0;
                } else if (position==ITEM){
                    textView = (TextView) itemView.findViewById(R.id.textView);
                    cardView2 = (CardView) itemView.findViewById(R.id.card2);
                    imageView2 = (ImageView) itemView.findViewById(R.id.im2);
                    imageView3 = (ImageView) itemView.findViewById(R.id.im3);
                    imageView4 = (ImageView) itemView.findViewById(R.id.im);
                    imageView5 = (ImageView) itemView.findViewById(R.id.imageView);
                    holderid = 1;
                }else
                {
                    holderid=2;
                }

            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
