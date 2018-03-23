package com.skorobahatko.practices.practice2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLNameParser {

    private String file;

    public HTMLNameParser(String file) {
        this.file = file;
    }

    public List<RatingPosition> parse(String regex) throws IOException {
        String text = FileUtils.getFileContentAsString(file);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<RatingPosition> ratingPositions = new ArrayList<>();
        while(matcher.find()) {
            int rank = Integer.parseInt(matcher.group("rank"));
            String maleName = matcher.group("maleName");
            String femaleName = matcher.group("femaleName");
            RatingPosition position = new RatingPosition(rank, maleName, femaleName);
            ratingPositions.add(position);
        }
        return ratingPositions;
    }
}
