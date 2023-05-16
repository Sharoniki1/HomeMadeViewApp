# HomeMadeViewApp

A simple satisfaction survey for general service.
It has 4 questions:
Was the service reliable?
Was the service professional?
Was the price fair?
Would you recommend the service?

Each of the questions has those 4 answers:
Not at all
In some level
Mostly yes
Perfect

After answers submitted, the answers will receive to activity for continuous usage.

Screenshot 2023-05-16 112010

Setup

step 1. Add it in your settings.gradle file under this section:

dependencyResolutionManagement {
repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
repositories {
maven { url 'https://jitpack.io' }
}
}

step 2. Add the dependency to your module:app gradle file:

dependencies {
implementation 'com.github.Sharoniki1:HomeMadeViewApp:Tag'
}

Usage

public class MainActivity extends AppCompatActivity {

Callback_answersReadyProtocol callback_answersReadyProtocol = new Callback_answersReadyProtocol() {
    @Override
    public void handleResults(ArrayList<Question> questions) {
        //TODO use the result
    }
};
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ConstraintLayout mainActivity = findViewById(R.id.main_LAY_mainactivitylay);

    SatisfactionSurvey.get().setCallback_answersReadyProtocol(callback_answersReadyProtocol);
    SatisfactionSurvey.get().initiateSurvey(this, mainActivity); // Inflates the view of the survey to activity's content view and initializes 
                                                                                                      the adapter with the added questions
}
}
