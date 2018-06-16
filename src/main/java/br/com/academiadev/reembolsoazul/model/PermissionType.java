package br.com.academiadev.reembolsoazul.model;

public enum PermissionType {
	ADMIN(1, "ROLE_ADMIN"), //
	USER(2, "ROLE_USER");

	private Integer id;

	private String description;

	PermissionType(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static PermissionType convertToEnum(Integer idTipoPermissao) {
		for (PermissionType permissiontype : values()) {
			if (permissiontype.getId() == idTipoPermissao)
				return permissiontype;
		}
		return null;
	}

}
