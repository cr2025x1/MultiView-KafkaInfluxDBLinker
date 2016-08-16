package chainlinker;

public class SnapLibVirtParser extends SnapPluginParser {
	public SnapLibVirtParser() {
		super();
		// All these data forms must be updated when snap publisher's output format is changed.
		
		// Pattern: /libvirt/(alphanumerical or _ or -)/disk/(alphanumerical(lowercase only) or _ or .)/(wrreq or rdreq or wrbytes or rdbytes)
		regexTypeMap.put("^\\/libvirt\\/([0-9]|[a-z]|_|-)*\\/disk\\/([0-9]|[a-z]|_|\\.)*\\/(wrreq|rdreq|wrbytes|rdbytes)$", lClass);
		// Pattern: /libvirt/(alphanumerical or _ or -)/mem/(mem or swap_in or swap_out or major_fault or minor_fault or free or max)
		regexTypeMap.put("^\\/libvirt\\/([0-9]|[a-z]|_|-)*\\/mem\\/(mem|swap_in|swap_out|major_fault|minor_fault|free|max)$", lClass);
		// Pattern: /libvirt/(alphanumerical or _ or -)/cpu/cputime
		regexTypeMap.put("^\\/libvirt\\/([0-9]|[a-z]|_|-)*\\/cpu\\/cputime$", lClass);
		// Pattern: /libvirt/(alphanumerical or _ or -)/cpu/(numerical not starting with 0 or 0 itself.)/cputime
		regexTypeMap.put("^\\/libvirt\\/([0-9]|[a-z]|_|-)*\\/cpu\\/(0|[1-9][0-9]*)\\/cputime$", lClass);
		// Pattern: /libvirt/(alphanumerical or _ or -)/net/(alphanumerical(lowercase only) or _ or .)/(rxbytes or rxpackets or rxerrs or rxdrop or txbytes or txpackets or txerrs or txdrop)
		regexTypeMap.put("^\\/libvirt\\/([0-9]|[a-z]|_|-)*\\/net\\/([0-9]|[a-z]|_|\\.)*\\/(rxbytes|rxpackets|rxerrs|rxdrop|txbytes|txpackets|txerrs|txdrop)$", lClass);
		
		regexSet = regexTypeMap.keySet();	
	}
}
