public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException(String characterName) {
        super(String.format("%s character does not exist in the characterActorFile and caused an error.", characterName));
    }
}
