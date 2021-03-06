/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2011-2016 Broad Institute, Aiden Lab
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package juicebox.tools.clt;

import juicebox.tools.clt.juicer.*;
import juicebox.tools.clt.old.*;
import juicebox.tools.utils.Benchmark;

/**
 * Factory for command line tools to call different functions
 *
 * @author Muhammad Shamim
 * @since 1/30/2015
 */
public class CLTFactory {

    // Commenting some out because we're not going to release all these when we release CLT
    private final static String[] commandLineToolUsages = {
            //        "addGWNorm",    "addGWNorm <input_HiC_file> <min resolution>",
            //        "addNorm",      "addNorm <input_HiC_file> [0 for no frag, 1 for no single frag]",
            //        "bigWig",       "bigWig <bigWig path or URL> <window size in bp> [chr] [start base] [end base]",
            //        "binToPairs",   "binToPairs <input_HiC_file> <output_HiC_file>",
            //        "bpToFrag",     "bpToFrag <fragmentFile> <inputBedFile> <outputFile>",
            //        "calcKR",       "calcKR <input_HiC_file>",
            //        "fragmentToBed","fragmentToBed <fragmentFile>",
            //        "pairsToBin",   "pairsToBin <input_HiC_file> <output_HiC_file> <genomeID>",
            //        "db",           "db <frag|annot|update> [items]",
            Dump.getUsage(),
            PreProcessing.getBasicUsage(),
            APA.getBasicUsage(),
            Arrowhead.getBasicUsage(),
            HiCCUPS.getBasicUsage(),
            HiCCUPSDiff.getBasicUsage(),
            ValidateFile.getUsage()
    };

    public static void generalUsage() {

        System.out.println("Juicebox and Juicer Command Line Tools Usage:");
        for (String usage : commandLineToolUsages) {
            System.out.println("\t\t" + usage);
        }
        System.out.println("Type juicebox <commandName> for more detailed usage instructions");
    }

    public static JuiceboxCLT getCLTCommand(String cmd) {

        cmd = cmd.toLowerCase();

        if (cmd.equals("pre")) {
            return new PreProcessing();
        } else if (cmd.equals("dump")) {
            return new Dump();
        } else if (cmd.equals("validate")) {
            return new ValidateFile();
        } else if (cmd.equals("addGWNorm".toLowerCase())) {
            return new AddGWNorm();
        } else if (cmd.equals("addNorm".toLowerCase())) {
            return new AddNorm();
        } else if (cmd.equals("apa")) {
            return new APA();
        } else if (cmd.equals("compare")) {
            return new CompareLists();
        } else if (cmd.equals("arrowhead")) {
            return new Arrowhead();
        } else if (cmd.equals("bigWig".toLowerCase())) {
            return new BigWig();
        } else if (cmd.equals("binToPairs".toLowerCase())) {
            return new BinToPairs();
        } else if (cmd.equals("bpToFrag".toLowerCase())) {
            return new BPToFragment();
        } else if (cmd.equals("calcKR".toLowerCase())) {
            return new CalcKR();
        } else if (cmd.equals("fragmentToBed".toLowerCase())) {
            return new FragmentToBed();
        } else if (cmd.equals("hiccups")) {
            return new HiCCUPS();
        } else if (cmd.equals("motifs")) {
            return new MotifFinder();
        } else if (cmd.equals("pairsToBin".toLowerCase())) {
            return new PairsToBin();
        } else if (cmd.equals("db")) {
            return new SQLDatabase();
        } else if (cmd.equals("hiccupsdiff")) {
            return new HiCCUPSDiff();
        } else if (cmd.equals("ab_compdiff")) {
            return new ABCompartmentsDiff();
        } else if (cmd.equals("benchmark")) {
            return new Benchmark();
        }

        return null;
    }
}
