# Accessibility
Accessible apps allow more users to use your app; however, it is usually an afterthought for developers, and it makes your XML layout files messy whether Accessibility was a forethought or afterthought. This library allows for hassle-free accessibility additions in your application — possibly in 1 line of code!

## Motivation

I was finishing up a project of mine, and as an afterthought, of course, I decided to add Accessibility of navigation in custom views and Accessibility of spoken text. Since I always disliked accessibility additions "uglifying" my XML Layout Resource files, I decided to do it programmatically; however, that typically would only "uglifying" my Java code, and if there is anything I dislike the more, it is ugly Java code. 

So for kicks and giggles, I went the Java code path and object-orientified it and was able to produce this libary.

## Usage

### Custom View

    public class CustomViewLayout extends RelativeLayout {
    
        // Called from Constructors
        private void init(AttributeSet attrs, int defStyle) {
    
            root = (ViewGroup) LayoutInflater.from(...);
    
            ...

            // Declare Navigation Accessibility
            Accessibility.with(root)
                    
                    // Disable certain views in the ViewGroup from ever gaining focus
                    .disableFocusableNavigationOn(
                            R.id.contribution_textview_creator,
                            R.id.contribution_textview_year)
    
                    // For all focusable views in the ViewGroup, set the D-pad Navigation
                    .setFocusableNavigationOn(txtProjectName)
                        .down(R.id.contribution_textview_description).complete()
                    .setFocusableNavigationOn(txtContributionDescription)
                        .up(R.id.contribution_textview_name)
                        .down(R.id.contribution_textview_link).complete()
                    .setFocusableNavigationOn(txtProjectLink)
                        .up(R.id.project_textview_description).complete()
    
                    // Set which view in the ViewGroup will have be first to be focused
                    .requestFocusOn(R.id.contribution_textview_name);
    
            invalidateView();
    
        }
      
        private void invalidateView() {
    
            ...
    
            // Declare Content Description Accessibility
            Accessibility.with(root)

                    // Set the content descriptions for each focusable view in the ViewGroup

                    // Set the content description for the Contribution Name
                    .setAccessibilityTextOn(txtProjectName)
                        .setModifiableContentDescription(getProjectName())
                            .prepend("Contribution occurred on the Project called ")
                            .append(String.format(" by %s in %s",
                                    getProjectCreator(),
                                    getContributionYear())).complete()

                    // Set the content description for the Contribution Description
                    .setAccessibilityTextOn(txtContributionDescription)
                        .setModifiableContentDescription(getContributionDescription())
                            .prepend("Description: ").complete()

                    // Set the content description for the Contribution URL
                    .setAccessibilityTextOn(txtProjectLink)
                        .setModifiableContentDescription(getProjectLink())
                            .prepend("URL is ").complete();
    
        }

        ...

    }
