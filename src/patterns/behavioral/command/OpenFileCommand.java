package patterns.behavioral.command;

public class OpenFileCommand implements Command{

    private FileSystemReceiver fileSystemReceiver;

    public OpenFileCommand(FileSystemReceiver fs){
        fileSystemReceiver = fs;
    }

    @Override
    public void execute() {
        fileSystemReceiver.openFile();
    }
}
