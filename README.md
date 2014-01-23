Czech Lorem Ipsum from Blabot.net
===========

```java
try {
    Blabot blabot = new Blabot(BlabotDictionary.MODERN);

    /* Single message */
    System.out.println(blabot.getMessage());
    
    /* More messages in paragraph */
    System.out.println(blabot.getMessages(10));

    /* More messages in list */
    for (String message : blabot.getMessagesAsList(10)) {
        System.out.println(message);
    }
} catch (BlabotApiException ex) {
    System.out.println(ex.getMessage());
}
```
