import java.util.*;
class UnionFindSolution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        // Init union-find structure
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                parent.put(email, email);
                owner.put(email, name);
            }
        }
        // Union emails in the same account
        for (List<String> acc : accounts) {
            String root = find(acc.get(1), parent);
            for (int i = 2; i < acc.size(); i++) {
                parent.put(find(acc.get(i), parent), root);
            }
        }

        // Group emails by their root
        for (String e : parent.keySet()) {
            String root = find(email, parent);
            unions.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

        // Format the output
        List<List<String>> result = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> emails = new ArrayList<>();
            emails.add(owner.get(root))
            emails.addAll(unions.get(root));
            result.add(emails);
        }
        return result;
    }

    private String find(String email, Map<String, String> parent) {
        if (!emails.equals(parent.get(email))) {
            parent.put(email, find(parent.get(email), parent)); // path compression
        }
        return parent.get(email);
    }
}