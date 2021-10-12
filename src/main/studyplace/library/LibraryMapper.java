package studyplace.library;

// Mapping the library to the passed name.
public class LibraryMapper {

    // EFFECTS: create a library based on the given name
    public static AbstractLibrary createLib(String name) {
        switch (name) {
            case Asian.NAME:
                return new Asian();
            case BiomedicalBranch.NAME:
                return new BiomedicalBranch();
            case DavidLam.NAME:
                return new DavidLam();
            case Education.NAME:
                return new Education();
            case IrvingKBarberLearning.NAME:
                return new IrvingKBarberLearning();
            case Koerner.NAME:
                return new Koerner();
            case Law.NAME:
                return new Law();
            case Woodward.NAME:
                return new Woodward();
            default:
                return new Xwi7xwa();
        }
    }

}
