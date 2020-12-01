package ui;

import java.util.Observer;

/**
 * Interface that is being implemented by abstract lights. Lights can therefore take multiple kind uf UI
 */
public interface UIObserver extends UIOutput, Observer {
}
