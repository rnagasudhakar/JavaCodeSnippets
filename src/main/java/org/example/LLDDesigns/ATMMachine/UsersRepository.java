package org.example.LLDDesigns.ATMMachine;

import java.util.HashMap;
import java.util.Map;

public class UsersRepository {
    private static UsersRepository instance;
    private final Map<Integer, User> usersByCardNumber;

    private UsersRepository() {
        usersByCardNumber = new HashMap<>();
    }

    public static UsersRepository getInstance() {
        if (instance == null) {
            instance = new UsersRepository();
        }
        return instance;
    }

    public void addUser(User user) {
        usersByCardNumber.put(user.card.getCardId(), user);
    }

    public User getUserByCard(Card card) {
        return usersByCardNumber.get(card.getCardId());
    }
}